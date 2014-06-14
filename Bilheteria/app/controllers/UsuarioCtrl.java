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
			@Required String bairro,   @Required String cidade,
			@Required String estado,   @Required String imagem) {
		
		System.out.println(imagem);
		
		if(senha.equals(senha2)){
                    Usuario usr = new Usuario(nome, cpf, email, endereco, telefone, dataNasc, login, senha, tipo,
                                              bairro, cidade, estado);
                    usr._save();
                    String tipoUsuario = session.get("tipo");

                    if (tipoUsuario != null && tipoUsuario.equals(Usuario.admin)) {
                            usuarioIndex();
                    } else {
                            indexLogin(null);
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
		//usuario.tipo = Integer.parseInt(request.params.get("tipo"));

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
	
	public static void efetivarMudarSenha(long id, @Required String atual,  @Required String nova1,
											@Required String nova2) {
		//função para fazer a mudança de senha no banco de dados
		Usuario usuario = Usuario.find("id", id).first();
		if(usuario != null && usuario.senha.equals(atual)){
			if(nova1.equals(nova2)){
				usuario.senha = nova1;
				usuario.save();
			} else {
				//Senhas não conferem
				usuarioAlterarSenha();
			}
		} else {
			//Senha errada
			usuarioAlterarSenha();
		}
		UsuarioCtrl.usuarioDadosPessoais();
	}	
	
	public static void usuarioSuspender(long id){
            Usuario usuario = Usuario.find("id", id).first();
            render(usuario);
	}
	
	public static void suspender(String login, Date tempo){
            Usuario usuario = Usuario.find("login", login).first();
            usuario.banido = true;
            usuario.dataBanido = tempo;
            usuario.save();
            usuarioIndex();
	}

	//--------------------LOGIN

	public static void entrar(@Required String login, @Required String senha) {
		
		Usuario usuario = Usuario.find("login", login).first();
		if(usuario == null){
                    //Exibir mensagem correspondente
                    indexLogin("Usuário inexistente");
		}
		if(usuario.banido){
			System.out.print(Calendar.getInstance().getTime());
			if(usuario.dataBanido.before(Calendar.getInstance().getTime())){
				usuario.banido = false;
				usuario.save();
			} else {
				//TODO Mostrar mensagem
				indexLogin("Você está banido, seu cabra de peia!");
			}
		}
		if(request.params.get("senha").equals(usuario.senha)){
			session.put("usuario", usuario.login);
			session.put("tipo", usuario.tipo);
			session.put("conectado", "V");
			if(Usuario.admin.equals(usuario.tipo))
				Application.index2();
			else
				Application.index();
		} else {
			indexLogin("Senha inválida");
		}
	}

	//Logout
	public static void logout(){
		session.clear();
		Application.index();
	}
	
	
	public static void esqueciMinhaSenha(@Required String cpf) {
            Usuario usuario = Usuario.find("cpf", cpf).first();
            int tela = 2;
            if(usuario != null){
                render("UsuarioCtrl/indexEsqueciSenha.html", usuario, tela);
            } else {
                //TODO Mostrar mensagem
            }
	}
	
	public static void alterarSenha(@Required String login, @Required String senha) {
            //System.out.println("Aqui " + login);
            //O login fica nulo, não sei porque
            Usuario usuario = Usuario.find("login", login).first();

            //TODO validar depois
            usuario.senha = senha;
            usuario.save();
            entrar(login, senha);
	}
	
	
	//----FUNÇÕES PARA ABRIR AS PÁGINAS
	
	/**Abre a página de login*/
	//TODO não sei se ele fica neste controlador
	public static void indexLogin(String erro) {
		render(erro);
	}

	public static void usuarioCadastrar() {
		render();    	
	}

	public static void usuarioCadastrar2() {
		render();    	
	}

	public static void indexEsqueciSenha() {
            int tela = 1;
            render(tela);
	}
	
	public static void usuarioAlterarSenha(){
            String lgn = session.get("usuario");

            if (lgn != null) {
                    Usuario usuario = Usuario.find("login", lgn).first();
                    render(usuario);
            }
	}

	
	public static void usuarioEditar(long id){
            Usuario usuario = Usuario.find("id", id).first();
            render(usuario);
	}
	
	public static void usuarioDadosPessoaisEditar(){
            String lgn = session.get("usuario");

            if (lgn != null) {
                    Usuario usuario = Usuario.find("login", lgn).first();
                    render(usuario);
            }
	}
	
	public static void usuarioDadosPessoais(){
            String lgn = session.get("usuario");

            if (lgn != null) {
                    Usuario usuario = Usuario.find("login", lgn).first();
                    render(usuario);
            }	
	}
	
	/**Carregar página de gerência de usuário*/
	public static void usuarioIndex() {
            if(session.get("tipo").equals(Usuario.comum)){
                    usuarioDadosPessoais();
            }
            List<Usuario> usr = Usuario.all().fetch();
            System.out.print("Teste " + usr.size());

            render(usr);
	}
	
}