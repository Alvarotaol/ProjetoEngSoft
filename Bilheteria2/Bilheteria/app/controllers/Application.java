package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import play.data.validation.*;

import java.sql.Time;
import java.util.*;

import models.*;

public class Application extends Controller {
//Cada método static aqui corresponde a uma página (creio eu)
//Desde que exista um html com o mesmo nome
    public static void index() {
    	List<Evento> eve = Evento.all().fetch();
        render(eve);
    }
    
    public static void cadastrarEvento(@Required String nome, @Required Date dia/*, @Required Time hora*/, @Required int quantidade){
    	
    	//Hora Não funciona
    	/*Logger.info("Teste " + params.get("hora"));
    	hora = hora.valueOf(params.get("hora").toString());/**/
    	Evento evento = new Evento(nome, dia, quantidade);
    	
		/*if (validation.hasErrors()) {
			render("Application/index.html", null);
		}//Quando tiver validação faz algo assim /**/

		evento.save();
		index();
    }
    
    public static void eventos() {
    	render();    	
    }
    
    public static void ingressos() {
    	render();    	
    }
    
}