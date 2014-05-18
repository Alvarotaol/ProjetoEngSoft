package controllers;

import java.text.*;
import java.util.*;

import models.Usuario;
import play.data.validation.Required;
import play.mvc.Controller;

public class UsuarioCtrl extends Controller {
	/**Manda o usuario para o banco*/
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
		//indexLogin();//TODO Deve ser colocado dentro de um if (se estiver logado não precisa chamar isso)
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
    /**Carregar página de gerência de usuário*/
    public static void usuarioIndex() {
    	List<Usuario> usr = Usuario.all().fetch();
    	System.out.print("Teste " + usr.size());
    	
    	render(usr);
    }

    //--------------------LOGIN
    
    public static void entrar(@Required String usuario, @Required String senha) {
    	
    }
    

    public static void esqueciMinhaSenha(@Required String CPF) {
    	
    }

    /**Abre a página de login*/
    //TODO não sei se ele fica neste controlador
    public static void indexLogin() {
    	render();
    }
    
    public static void usuarioCadastrar() {
    	render();    	
    }
    
    public static void usuarioCadastrar2() {
    	render();    	
    }
    
    public static void indexEsqueciSenha() {
    	render();
    }
}
