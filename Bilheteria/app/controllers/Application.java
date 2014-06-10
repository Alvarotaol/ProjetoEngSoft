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

import models.*;

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
    
    public static void indexProxJogos() {
    	List<Evento> eventos = Evento.all().fetch();
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
    
}