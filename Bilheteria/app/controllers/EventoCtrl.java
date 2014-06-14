package controllers;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.*;
import java.util.*;

import models.Cadeira;
import models.Estadio;
import models.Evento;
import models.Fileira;
import models.Setor;
import models.SetorDisponivelPartida;
import models.TimeFutebol;
import models.Usuario;
import play.data.validation.Required;
import play.db.DB;
import play.mvc.Controller;

public class EventoCtrl extends Controller {
    
	//------------EVENTOS
    /**Manda o usuario para o banco*/
    public static void criarEvento(@Required String desc,      @Required long id_estadio,
                                                               @Required long id_mandante, @Required long id_visitante,
                                                               @Required Date dia, @Required String hora, @Required Date diaLimite) throws SQLException {

        Evento ev = new Evento(desc, id_estadio, id_mandante, id_visitante, dia, hora, 2, diaLimite);
        ev._save();

        List<Setor> setores = Setor.find("id_estadio", (long)id_estadio).fetch();
        for (int i=0; i < setores.size(); i++) {
            SetorDisponivelPartida s = new SetorDisponivelPartida(ev.id, setores.get(i).id, 0, 0);
            s.save();
        }

        eventosIndex();
    }
    
    public static void disponibilizarSetor(long id_setor, long id_evento, long id_estadio, @Required String valor) throws SQLException {
        SetorDisponivelPartida est = SetorDisponivelPartida.find("id_evento=? and id_setor=?", id_evento, id_setor).first();

        if (validation.hasErrors()) {
            render("Application/usuarioEditar.html", est);
        }

        est.status = 1;
        est.valor = Float.parseFloat(valor);

        est.save();        
        setoresDisponiveis(id_evento, id_estadio);
    }
    
    public static void indisponibilizarSetor(long id_setor, long id_evento, long id_estadio) throws SQLException {
        SetorDisponivelPartida est = SetorDisponivelPartida.find("id_evento=? and id_setor=?", id_evento, id_setor).first();

        if (validation.hasErrors()) {
            render("Application/usuarioEditar.html", est);
        }

        est.status = 2;
        est.valor = 0;

        est.save();        
        setoresDisponiveis(id_evento, id_estadio);
    }
   
    //Esses nomes precisam ser alterados para manter o padrão de nomes
    public static void eventosIndex() throws SQLException {
        String query = "select ev.id as id_evento, ev.descricao as descric, ev.dataEvento as dia, ev.hora as hora, ev.dataFinalCompra as limite, " +
                              "es.id as id_estadio, es.nome as nomeEstadio, m.nomeTime as mandante, v.nomeTime as visitante " +

	               "from evento ev, estadio es, timefutebol m, timefutebol v " + 

	               "where ev.id_estadio = es.id and ev.id_mandante = m.id and ev.id_visitante = v.id ORDER BY dia;";
        
        ResultSet rs = DB.executeQuery(query);

        List<joinEventosNaPagAdministrador> eventos = new ArrayList();
            
       while(rs.next()) {
            joinEventosNaPagAdministrador j = new joinEventosNaPagAdministrador();

            j.setId_estadio(rs.getLong("id_estadio"));
            j.setId_evento(rs.getLong("id_evento"));
            j.setDescricao(rs.getString("descric"));
            j.setNomeEstadio(rs.getString("nomeEstadio"));
            j.setMandante(rs.getString("mandante"));
            j.setVisitante(rs.getString("visitante"));
            if(rs.getDate("dia") != null) j.setData(rs.getDate("dia").toString());
            j.setHora(rs.getString("hora"));
            if(rs.getDate("limite") != null) j.setDataLimite(rs.getDate("limite").toString());
            
            eventos.add(j);
        }

        rs.close();
        
    	render(eventos);
    }
    
    public static void apagar(long id) throws SQLException {
    	Evento evento = Evento.find("id", id).first();
		evento.delete();
		eventosIndex();
    }
    
    public static void editar(long id){
    	Evento evento = Evento.find("id", id).first();
		render(evento);
    }
    
    public static void editarEvento(long id) throws SQLException{
        Evento evento = Evento.find("id", id).first();

        if (validation.hasErrors()) {
            render("Application/editar.html", evento);
        }

        SimpleDateFormat formatar = new SimpleDateFormat("yyyy-mm-dd");
        evento.descricao = request.params.get("nome");

        try {
            evento.dataEvento = formatar.parse(request.params.get("dia"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        evento.hora = request.params.get("hora");
        evento.save();
        
        eventosIndex();
    }
    
    public static void eventosCadastrar() {
    	List<Estadio> estadio = Estadio.all().fetch();
    	List<TimeFutebol> time = TimeFutebol.all().fetch();
    	render(estadio, time);
    }
    
    public static void setor(long idevento, long id) throws SQLException {
    	if(session.get("conectado") != null){
            
            String query = "select s.id as id_setor, s.nome as nomeSetor, sdp.valor as val "+
                           "from setor s, setordisponivelpartida sdp, evento ev "+
                           "where sdp.status = 1 and ev.id = "+idevento+" and sdp.id_setor = s.id and sdp.id_evento = ev.id;";
            
            ResultSet rs = DB.executeQuery(query);

            List<joinSelecionarSetorDisponivel> setores = new ArrayList();
            while(rs.next()) {
                joinSelecionarSetorDisponivel j = new joinSelecionarSetorDisponivel();
                j.setId_setor(rs.getLong("id_setor"));
                j.setNomeSetor(rs.getString("nomeSetor"));
                
                DecimalFormat df = new DecimalFormat("0.00"); //colocar duas casas decimais no valor do ingresso
                j.setPreco("R$ "+df.format(rs.getFloat("val")));
                
                setores.add(j);
            }
            rs.close();
            
            render(idevento, setores);
    	} else {
            UsuarioCtrl.indexLogin(null);
    	}
    }
    
    public static void fileira(long idevento, long id_setor) {
    	if(session.get("conectado") != null){
            //Estadio estadio = Estadio.find("id", id).first();
            List<Fileira> fileiras = Fileira.find("id_setor", id_setor).fetch();
            render(idevento, fileiras);
    	} else {
            UsuarioCtrl.indexLogin(null);
    	}
    }
    
    public static void cadeira(long idevento, long id_fileira) throws SQLException {
    	if(session.get("conectado") != null){
            //Estadio estadio = Estadio.find("id_fileira", id_fileira).first();
            int st = 1;
            
            String qry = "select ca.id as ca_id, ca.nome as ca_nome, ca.status as ca_status " + 
                         "from cadeira ca " +
                         "where ca.id_fileira = "+id_fileira+
                         " and ca.id not in (select id_cadeira from ingresso where id_evento = "+idevento+")";

            ResultSet rs = DB.executeQuery(qry);

            List<joinCadeirasQueNaoForamCompradas> cadeiras = new ArrayList();
            while(rs.next()) {
                joinCadeirasQueNaoForamCompradas j = new joinCadeirasQueNaoForamCompradas();

                j.setId_cadeira(rs.getLong("ca_id"));
                j.setNomeCadeira(rs.getString("ca_nome"));
                j.setStatus(rs.getInt("ca_status"));

                cadeiras.add(j);
            }
            rs.close();
            
            
            render(idevento, cadeiras);
    	} else {
            UsuarioCtrl.indexLogin(null);
    	}
    }
    
    public static void setoresDisponiveis(long id_evento, long id_estadio) throws SQLException {
        String q2 = "select se.id as id_evento, se.nome as nome, sdp.status as status, sdp.valor as valor " +
                    "from setor se, setordisponivelpartida sdp, evento e " +
                    "where se.id = sdp.id_setor and sdp.id_evento = "+ id_evento+" and e.id = sdp.id_evento and se.id_estadio = "+id_estadio;
        
        ResultSet rs = DB.executeQuery(q2);

        List<joinSetoresDisponiveis> setores = new ArrayList();

        while(rs.next()) {
            joinSetoresDisponiveis j = new joinSetoresDisponiveis();

            j.setId_setor(rs.getLong("id_evento"));
            j.setNomeSetor(rs.getString("nome"));
            j.setStatus(rs.getInt("status"));
            j.setValor(rs.getFloat("valor"));

            setores.add(j);
        }

        rs.close();
                
        render(id_evento, id_estadio, setores);
    }
    
    public static void setorDisponibilizarValor(long id_setor, long id_evento, long id_estadio) {
        render(id_setor, id_evento, id_estadio);
   }
   
    public static void mostrarUsuariosQueCompraram(long id_evento) throws SQLException {
       
        String query = "select u.nome nomeUsuario, u.login as usr, u.cpf as cpf, str.nome as nomeSetor, fil.nome as nomeFileira, ca.nome as nomeCadeira, sdp.valor as val "+
                       "from usuario u,  evento ev, ingresso i, cadeira ca, fileira fil, setor str, setordisponivelpartida sdp "+
                       "where i.id_usuario = u.id and ev.id = i.id_evento and sdp.id_setor = str.id and sdp.id_evento = ev.id and i.id_evento = "+id_evento+" "+
                       "and ca.id = i.id_cadeira and ca.id_fileira = fil.id and fil.id_setor = str.id " +
                       "order by nomeSetor, nomeFileira, nomeCadeira ";
       
        ResultSet rs = DB.executeQuery(query);

        List<joinUsuariosQueCompraram> comprados = new ArrayList();

        while(rs.next()) {
            joinUsuariosQueCompraram j = new joinUsuariosQueCompraram();

            j.setNomeSetor(rs.getString("nomeSetor"));
            j.setNomeFileira(rs.getString("nomeFileira"));
            j.setNomeCadeira(rs.getString("nomeCadeira"));
            j.setNomeUsuario(rs.getString("nomeUsuario"));
            j.setCpf(rs.getString("cpf"));
            j.setUsr(rs.getString("usr"));
            
            DecimalFormat df = new DecimalFormat("0.00"); //colocar duas casas decimais no valor do ingresso
            j.setValor("R$ "+df.format(rs.getFloat("val")));
            
            comprados.add(j);
        }

        rs.close();
        render(comprados);
   }
}