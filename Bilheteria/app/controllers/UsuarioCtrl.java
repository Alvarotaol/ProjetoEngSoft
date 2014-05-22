package controllers;

import java.text.*;
import java.util.*;
import java.sql.Timestamp;

import models.Usuario;
import play.data.validation.Required;
import play.mvc.Controller;
import play.mvc.Scope.Session;

public class UsuarioCtrl extends Controller {
	/**Manda o usuario para o banco*/
	public static void criarUsuario(@Required String nome,     @Required String cpf,
			@Required String email,    @Required String endereco,
			@Required String telefone, @Required Date   dataNasc,
			@Required String login,    @Required String senha,
			@Required String senha2,   @Required int    tipo, 
			@Required String bairro, @Required String cidade,
			@Required String estado) {
		System.out.println(nome);
		System.out.println(cpf);
		System.out.println(email);
		System.out.println(endereco);
		System.out.println(telefone);
		System.out.println(dataNasc);
		System.out.println(login);
		System.out.println(senha);
		System.out.println(tipo);
		System.out.println(bairro);
		System.out.println(cidade);
		System.out.println(estado);
		if(senha.equals(senha2)){
			Usuario usr = new Usuario(nome, cpf, email, endereco, telefone, dataNasc, login, senha, tipo,
				                  bairro, cidade, estado);
			usr._save();
			String as = session.get("tipo");

			if (as != null && as.equals("1")) {
				usuarioIndex();
			} else {
				indexLogin();
			}
		} else {
			usuarioCadastrar(); //+ mensagem de senhas diferentes
		}

		/*if (validation.hasErrors()) {
			render("Application/index.html", null);
		}//Quando tiver validação faz algo assim */

		//Testes pra tentar resolver o problema da data na edição
		//Timestamp ts = new Timestamp(123);
		//ts.

		

	}

	public static void usuarioEditar(long id){
		Usuario usuario = Usuario.find("id", id).first();
		render(usuario);
	}

	public static void salvarAlteracoesUsuario(long id){

		Usuario usuario = Usuario.find("id", id).first();

		if (validation.hasErrors()) {
			render("Application/usuarioEditar.html", usuario);
		}

		usuario.nome = request.params.get("nome");
		usuario.cpf = request.params.get("cpf");
		usuario.email = request.params.get("email");
		usuario.telefone = request.params.get("telefone");

		usuario.endereco = request.params.get("endereco");
		usuario.bairro = request.params.get("bairro");
		usuario.cidade = request.params.get("cidade");
		usuario.estado = request.params.get("estado");

		try {
			SimpleDateFormat formatar = new SimpleDateFormat("yyyy-mm-dd");
			usuario.dataNasc = formatar.parse(request.params.get("dataNasc"));
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

	public static void entrar(@Required String login, @Required String senha) {
		//TODO precisa de tratamento de excessões
		Usuario usuario = Usuario.find("login", login).first();
		if(request.params.get("senha").equals(usuario.senha)){
			session.put("usuario", usuario.login);
			session.put("tipo", usuario.tipo);
			session.put("conectado", "V");
			//TODO Colocar dentro de um if: se não for administrador não pode acessar essa página
			if(usuario.tipo == 1)
				Application.index2();
			else
				Application.index();
		} else {
			System.out.println(usuario.senha + " " + request.params.get("senha"));
			usuarioCadastrar2();
		}
	}

	//Logout
	public static void logout(){
		session.clear();
		Application.index();
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
