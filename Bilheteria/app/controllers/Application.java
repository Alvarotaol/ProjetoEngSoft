package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import play.data.validation.*;
import play.db.jpa.JPA;

import java.sql.SQLException;
import java.util.*;
import java.sql.ResultSet;
import java.text.DecimalFormat;

import models.*;
import play.db.DB;

public class Application extends Controller {
//Cada método static aqui corresponde a uma página (creio eu)
//Desde que exista um html com o mesmo nome
    public static void index() {
    	if(session.get("usuario") == null){
            session.put("usuario", "Visitante");
    	}
    	String st = session.get("tipo");
    	if(st != null && st.equals("1")){
    		index2();
    	} if(session.get("conectado") != "V") { 
    		render();
    	} else {
    	
    		Usuario usuario = Usuario.find("login", session.get("usuario")).first();
    		List<Ingresso> ingressos = Ingresso.find("id_usuario", usuario.id).fetch();
    		//System.out.println("ID do usuário ativo " + ingressos.size());
    		/*List<Evento> eventos = new ArrayList<Evento>();
    		List<Estadio> estadios;
    		List<Setor> setores;
    		List<Fileira> fileiras;
    		List<Cadeira> cadeiras;*/
    		List<List<String>> compras = new ArrayList<List<String>>();
    		for(Ingresso ingresso: ingressos){
				Evento ev = Evento.find("id", ingresso.id_evento).first();
				Estadio es = Estadio.find("id", ev.id_estadio).first();
				Cadeira ca = Cadeira.find("id", ingresso.id_cadeira).first();
				Fileira fi = Fileira.find("id", ca.id_fileira).first();
				Setor se = Setor.find("id", fi.id_setor).first();
				List<String> compra = new ArrayList<String>();
				compra.add(ev.descricao);
				compra.add(es.nome);
				compra.add(se.nome);
				compra.add(fi.nome);
				compra.add(ca.nome);
				compras.add(compra);
    		}
        	render(compras);
    	}
    }

    public static void index2() {
    	String st = session.get("tipo");
    	if(st != null && st.equals("1")){
    		//List<Evento> eve = Evento.all().fetch();
            render();
    	} else {
        	index();
    	}    	
    }
    
    public static int verificaSeOUsuarioComprouIngressoParaTalJogo(long id_evento) throws SQLException {
        Usuario usuario = Usuario.find("login", session.get("usuario")).first();
        
        String query = "Select id from Ingresso where id_evento ="+id_evento+" and id_usuario = "+usuario.id;
        
        ResultSet rs = DB.executeQuery(query);
        
        List<Long> ids = new ArrayList();            
        while(rs.next()) {
            ids.add(rs.getLong("id"));
        }       
        rs.close();
        
        if(ids.isEmpty()) {
            return(0);
        }        
        return(1);
    }
    
    public static void indexProxJogos() throws SQLException {
    	String query = "select ev.id as id_evento, ev.id_estadio as id_estadio, ev.descricao as descricao, "+
                       "es.nome as nomeEstadio, m.nometime as mandante, v.nometime as visitante, ev.dataEvento as dia, "+
                       "ev.hora as hora, ev.dataFinalCompra as limite "+
                       "from Estadio es, TimeFutebol m, TimeFutebol v, Evento ev " +
                       "where ev.id_estadio = es.id and ev.id_mandante = m.id and ev.id_visitante = v.id and ev.dataFinalCompra >= now() ORDER BY ev.dataEvento";
        
        ResultSet rs = DB.executeQuery(query);

        List<joinEventosDisponiveisParaCompra> eventos = new ArrayList();
            
       while(rs.next()) {
            joinEventosDisponiveisParaCompra j = new joinEventosDisponiveisParaCompra();

            j.setId_estadio(rs.getLong("id_estadio"));
            j.setId_evento(rs.getLong("id_evento"));
            j.setDescricao(rs.getString("descricao"));
            j.setNomeEstadio(rs.getString("nomeEstadio"));
            j.setNomeMandante(rs.getString("mandante"));
            j.setNomeVisitante(rs.getString("visitante"));
            
            if (rs.getDate("dia") != null)
                j.setDataEvento(rs.getDate("dia").toString());
            
            j.setHoraEvento(rs.getString("hora"));
            
            if (rs.getDate("limite") != null)
                j.setDataFinalCompra(rs.getDate("limite").toString());
            
            if(session.get("conectado") != null) {
                if(session.get("conectado").equals("V")) {
                    j.setComprou(verificaSeOUsuarioComprouIngressoParaTalJogo(j.getId_evento()));
                }
            }
            
            eventos.add(j);
        }

        rs.close();
        
    	render(eventos);
    }
    
    
    public static void ingressos() {
    	render();    	
    }
    
    public static void comprar(long idcadeira, long idevento) {
        Cadeira cadeira = Cadeira.find("id", idcadeira).first();
        Usuario usuario = Usuario.find("login", session.get("usuario")).first();
        Ingresso ingresso = new Ingresso(null, null, usuario.id, idevento, idcadeira);
        ingresso.save();
        Application.index();
    }
    
    public static void indexIngressosComprados() throws SQLException {
        Usuario usuario = Usuario.find("login", session.get("usuario")).first();
        
        String query =  "Select ev.descricao as descricao, es.nome as nomeEstadio, ma.nometime as mandante, " +
                        "vi.nometime as visitante, ev.dataEvento as dia, ev.hora as hora, se.nome as sector, fil.nome as fileir, ca.nome as cad, sdp.valor as val " +
                        "from Evento ev, Estadio es, Timefutebol ma, timefutebol vi, ingresso i, setor se, fileira fil, cadeira ca, " +
                        "setordisponivelpartida sdp " +
                        "where i.id_evento = ev.id and ev.id_estadio = es.id and ev.id_mandante = ma.id and ev.id_visitante = vi.id and i.id_usuario = "+ usuario.id +" "+
                        "and i.id_cadeira = ca.id and ca.id_fileira = fil.id and fil.id_setor = se.id and se.id_estadio = es.id and sdp.id_evento = ev.id and sdp.id_setor = se.id";
        
        ResultSet rs = DB.executeQuery(query);

        List<joinJogosComprados> eventos = new ArrayList();
        
        while(rs.next()) {
            joinJogosComprados j = new joinJogosComprados();
            
            j.setDescricao(rs.getString("descricao"));
            j.setNomeEstadio(rs.getString("nomeEstadio"));
            j.setNomeMandante(rs.getString("mandante"));
            j.setNomeVisitante(rs.getString("visitante"));
            
            if (rs.getDate("dia") != null)
                j.setData(rs.getDate("dia").toString());
            
            j.setHora(rs.getString("hora"));
            j.setSec(rs.getString("sector"));
            j.setFil(rs.getString("fileir"));
            j.setCad(rs.getString("cad"));
            
            DecimalFormat df = new DecimalFormat("0.00"); //colocar duas casas decimais no valor do ingresso
            j.setValor("R$ "+df.format(rs.getFloat("val")));
            
            eventos.add(j);
        }
        
        render(eventos);
    }
    
}