package controllers;

import java.sql.SQLException;
import java.text.*;
import java.util.*;

import models.Evento;
import models.TimeFutebol;
import play.data.validation.Required;
import play.mvc.Controller;

public class EventoCtrl extends Controller {
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
    
    //Esses nomes precisam ser alterados para manter o padrão de nomes
    public static void eventos() {
    	List<Evento> eventos = Evento.all().fetch();
    	render(eventos);
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
		Evento evento = Evento.find("id", id).first();

		if (validation.hasErrors()) {
			render("Application/editar.html", evento);
		}
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy-mm-dd");
		evento.nome = request.params.get("nome");
		try {
			evento.data = formatar.parse(request.params.get("dia"));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		evento.hora = request.params.get("hora");
		evento.save();
    	Application.index();
    }
}
