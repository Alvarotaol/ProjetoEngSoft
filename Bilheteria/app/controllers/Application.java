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
    	render();
    }

    public static void index2() {
    	List<Evento> eve = Evento.all().fetch();
        render(eve);
    }
    
    public static void indexProxJogos() {
    	render();
    }
    
    //------------EVENTOS
    public static void cadastrarEvento(@Required String nome, @Required Date dia, @Required String hora, @Required int quantidade){
    	/*
    	Logger.info("Valor hora: " + hora);
    	Evento evento = new Evento(nome, dia, hora, quantidade);
    	
		/*if (validation.hasErrors()) {
			render("Application/index.html", null);
		}//Quando tiver validação faz algo assim

		evento.save();
		index(); */
    }
    
    public static void eventos() {
    	render();    	
    }
    
    public static void ingressos() {
    	render();    	
    }
    
    public static void apagar(long id) throws SQLException {
    	Evento evento = Evento.find("id", id).first();
		evento.delete();
		eventos();
    }
    
    public static void editar(long id){
    	Evento evento = Evento.find("id", id).first();
		render(evento);
    }
    
    public static void editarEvento(long id){
    	/*
		Evento evento = Evento.find("id", id).first();

		if (validation.hasErrors()) {
			render("Application/editar.html", evento);
		}
		SimpleDateFormat formatar = new SimpleDateFormat();
		evento.nome = request.params.get("nome");
		evento.quantidade = Integer.parseInt(request.params.get("quantidade"));
		try {
			evento.data = formatar.parse(request.params.get("dia"));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		evento.hora = request.params.get("hora");
		evento.save();
    	index(); */
    }
}