package controllers;

import models.Estadio;
import models.Setor;
import models.Usuario;
import play.data.validation.Required;
import play.mvc.Controller;

public class SetorCtrl extends Controller {
	
	//CRIAR, EDITAR, EXCLUIR
	public static void criarSetor(long id_estadio, @Required String nomeS) {
		Setor s = new Setor(nomeS, id_estadio);
		s.save();
		EstadioCtrl.estadioExibir(id_estadio);
	}
	
	public static void setorApagar(long id, long id_estadio) {
		Setor s = Setor.find("id", id).first();
		s.delete();
		EstadioCtrl.estadioExibir(id_estadio);
	}
	
	public static void salvarAlteracoesSetor(long id, long id_estadio){
		Setor s = Setor.find("id", id).first();

		if (validation.hasErrors()) {
			render("Application/usuarioEditar.html", s);
		}

		s.nome = request.params.get("nome");

		s.save();
		EstadioCtrl.estadioExibir(id_estadio);
	}
	
	//Abrir páginas
	public static void setorEditar(long id){
		Setor setor = Setor.find("id", id).first();
		render(setor, setor.id_estadio);
	}
}