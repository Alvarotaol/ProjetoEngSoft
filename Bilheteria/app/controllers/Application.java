package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import play.data.validation.*;
import play.db.jpa.JPA;

import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.management.Query;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;

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
    
    /*
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
     */
    
    public static void indexProxJogos() throws SQLException {
    	String query = "select ev.id as id_evento, ev.id_estadio as id_estadio, p.descricao as descricao, "+
                       "es.nome as nomeEstadio, m.nometime as mandante, v.nometime as visitante, ev.dataEvento as dia, "+
                       "ev.hora as hora, ev.dataFinalCompra as limite "+
                       "from evento p, estadio es, timefutebol m, timefutebol v, evento ev " +
                       "where es.id = p.id_estadio and m.id = p.id_mandante and v.id = p.id_visitante and ev.dataFinalCompra >= now()";
        
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
            j.setDataEvento(rs.getDate("dia").toString());
            j.setHoraEvento(rs.getString("hora"));
            j.setDataFinalCompra(rs.getDate("limite").toString());
            
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
                        "vi.nometime as visitante, ev.dataEvento as dia, ev.hora as hora, se.nome as sector, fil.nome as fileir, ca.nome as cad " +
                        "from evento ev, estadio es, timefutebol ma, timefutebol vi, ingresso i, setor se, fileira fil, cadeira ca " +
                        "where i.id_evento = ev.id and ev.id_estadio = es.id and ev.id_mandante = ma.id and ev.id_visitante = vi.id and i.id_usuario = "+ usuario.id +" "+
                        "and i.id_cadeira = ca.id and ca.id_fileira = fil.id and fil.id_setor = se.id and se.id_estadio = es.id";
        
        ResultSet rs = DB.executeQuery(query);

        List<joinJogosComprados> eventos = new ArrayList();
        
        while(rs.next()) {
            joinJogosComprados j = new joinJogosComprados();
            
            j.setDescricao(rs.getString("descricao"));
            j.setNomeEstadio(rs.getString("nomeEstadio"));
            j.setNomeMandante(rs.getString("mandante"));
            j.setNomeVisitante(rs.getString("visitante"));
            j.setData(rs.getDate("dia").toString());
            j.setHora(rs.getString("hora"));
            j.setSec(rs.getString("sector"));
            j.setFil(rs.getString("fileir"));
            j.setCad(rs.getString("cad"));
            
            eventos.add(j);
        }
        
        render(eventos);
    }
    
}