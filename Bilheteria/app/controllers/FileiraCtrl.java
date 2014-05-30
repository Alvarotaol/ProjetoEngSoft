package controllers;

import models.Fileira;
import play.data.validation.Required;
import play.mvc.Controller;

public class FileiraCtrl extends Controller {
	public static void criarFileira(long id_estadio, long id_setor, String nome, @Required String nomeF) {
		Fileira f = new Fileira(nomeF, id_setor);
		f.save();
		SetorCtrl.setorExibir(id_estadio, id_setor, nome);
	}
	
	public static void fileiraApagar(long id, long id_estadio, long id_setor, String nome) {
		Fileira f = Fileira.find("id", id).first();
		f.delete();
		SetorCtrl.setorExibir(id_estadio, id_setor, nome);
	}
}