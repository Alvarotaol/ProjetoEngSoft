package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import play.data.validation.*;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import models.*;

public class Application extends Controller {
//Cada método static aqui corresponde a uma página (creio eu)
//Desde que exista um html com o mesmo nome
    public static void index() {
    	List<Evento> eve = Evento.all().fetch();
        render(eve);
    }    
    
    public static void cadastrarEvento(@Required String nome, @Required Date dia, @Required String hora, @Required int quantidade){
    	
    	Logger.info("Valor hora: " + hora);
    	Evento evento = new Evento(nome, dia, hora, quantidade);
    	
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
    
    public static void usuarioCadastrar() {
    	render();    	
    }
    
    public static void apagar(long id) {
    	Evento evento = Evento.find("id", id).first();
		evento.delete();
		index();
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
    	index();
    }
    
    //-------------------USUÁRIOS
    public static void cadastrarUsuario(@Required String nome, @Required String cpf,
    									@Required String email, @Required String endereco,
    									@Required String telefone, @Required Date dia) {
    	Usuario usr = new Usuario(nome, cpf, email, endereco, telefone, dia);
    	
		/*if (validation.hasErrors()) {
			render("Application/index.html", null);
		}//Quando tiver validação faz algo assim /**/

		usr._save();
		usuarioIndex();
    }
    
    public static void usuarioEditar(long id){
    	Usuario usuario = Usuario.find("id", id).first();
		render(usuario);
    }
    
    public static void usuarioEditar2(long id){

		Usuario usuario = Usuario.find("id", id).first();

		if (validation.hasErrors()) {
			render("Application/usuarioEditar.html", usuario);
		}
		
		SimpleDateFormat formatar = new SimpleDateFormat();
		usuario.nome = request.params.get("nome");
		usuario.cpf = request.params.get("cpf");
		usuario.email = request.params.get("email");
		usuario.endereco = request.params.get("endereco");
		usuario.telefone = request.params.get("telefone");
		
		try {
			usuario.dNasc = formatar.parse(request.params.get("dia"));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		usuario.save();
    	usuarioIndex();
    }
    
    public static void usuarioApagar(long id) {
    	Usuario usuario = Usuario.find("id", id).first();
		usuario.delete();
		usuarioIndex();
    }
    
    public static void usuarioIndex() { //carregar página de gerencia de usuário
    	List<Usuario> usr = Usuario.all().fetch();
        render(usr);
    }
}