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

public class EstadioCtrl extends Controller {
	
	public static void criarEstadio(@Required String nome,   @Required String endereco,
									@Required String bairro, @Required String cidade,
									@Required String estado, @Required String cep) {
		
		Estadio usr = new Estadio(nome, endereco, bairro, cidade, estado, cep);
		
		usr._save();
		estadioIndex();
	}
	
	public static void estadioApagar(long id) {
		Estadio estadio = Estadio.find("id", id).first();
		estadio.delete();
		estadioIndex();
	}
	

	//------Funções para abrir as páginas
	public static void estadioIndex() {
		List<Estadio> est = Estadio.all().fetch();
		System.out.print("Teste " + est.size());
		
		render(est);
	}
	
	public static void estadioCadastrar() {
		render();
	}
}