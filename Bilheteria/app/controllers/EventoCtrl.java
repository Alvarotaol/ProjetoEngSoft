package controllers;

import java.sql.SQLException;
import java.text.*;
import java.util.*;

import models.Estadio;
import models.Evento;
import models.TimeFutebol;
import models.Usuario;
import play.data.validation.Required;
import play.mvc.Controller;

public class EventoCtrl extends Controller {
	//------------EVENTOS
	/**Manda o usuario para o banco*/
	public static void criarEvento(@Required String desc,      @Required long id_estadio,
								   @Required long id_mandante, @Required long id_visitante,
								   @Required Date dia, @Required String hora, @Required Date diaLimite) {
		
		Evento ev = new Evento(desc, id_estadio, id_mandante, id_visitante, dia, hora, 0, diaLimite);

		ev._save();

		eventosIndex();
	}
    
    //Esses nomes precisam ser alterados para manter o padrão de nomes
    public static void eventosIndex() {
    	List<Evento> eventos = Evento.all().fetch();
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
    
    public static void editarEvento(long id){
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
    	Application.index();
    }
    
    public static void eventosCadastrar() {
    	List<Estadio> estadio = Estadio.all().fetch();
    	List<TimeFutebol> time = TimeFutebol.all().fetch();
    	render(estadio, time);
    }
}