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
    
    public static void indexLogin() {
    	render();
    }
    
    public static void indexEsqueciSenha() {
    	render();
    }
    
    public static void indexProxJogos() {
    	render();
    }
    
    //-------abrir páginas relacionadas a times
    public static void timesIndex() {
    	List<TimeFutebol> time = TimeFutebol.all().fetch();
    	render(time);
    }
    
    public static void timesCadastrar() {
    	render();
    }
    
    public static void timesEditar(long id){ //carrega o time que quer editar e manda pra página
    	TimeFutebol timefutebol = TimeFutebol.find("id", id).first();
		render(timefutebol);
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
    
    public static void usuarioCadastrar() {
    	render();    	
    }
    
    public static void usuarioCadastrar2() {
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
    
    //-------------------USUÁRIOS        
    public static void cadastrarUsuario(@Required String nome,     @Required String cpf,
    									@Required String email,    @Required String endereco,
    									@Required String telefone, @Required Date   dNasc,
    									@Required String login,    @Required String senha,
    									@Required String senha2,   @Required int    tipo, 
    									@Required int    banido) {
    	Usuario usr = new Usuario(nome, cpf, email, endereco, telefone, dNasc, login, senha, 3, 0);
    	
		/*if (validation.hasErrors()) {
			render("Application/index.html", null);
		}//Quando tiver validação faz algo assim */

		usr._save();
		indexLogin();
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
    
    //--------------------LOGIN
    
    public static void entrar(@Required String usuario, @Required String senha) {
    	
    }
    

    public static void esqueciMinhaSenha(@Required String CPF) {
    	
    }
    
    //------TIMES
    public static void cadastrarTime(@Required String nome, @Required String cnpj, @Required String ano) {
    	
    	TimeFutebol time = new TimeFutebol(nome, cnpj, ano);

		/*if (validation.hasErrors()) {
			render("Application/index.html", null);
		}//Quando tiver validação faz algo assim */

    	time._save();
		timesIndex();
    }
    
    public static void timeApagar(long id) {
    	TimeFutebol time = TimeFutebol.find("id", id).first();
		time.delete();
		timesIndex();
    }
    
    public static void timeEditar(long id){
		TimeFutebol time = TimeFutebol.find("id", id).first();

		if (validation.hasErrors()) {
			render("Application/timesEditar.html", time);
		}
		
		time.nomeTime = request.params.get("nome");
		time.cnpjTime = request.params.get("cnpj");
		time.anoFundacao = request.params.get("ano");
		
		time.save();
    	timesIndex();
    }
}