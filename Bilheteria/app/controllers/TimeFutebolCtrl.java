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

public class TimeFutebolCtrl extends Controller{
	/**Abre a página relacionada a times*/
    public static void timesIndex() {
    	List<TimeFutebol> time = TimeFutebol.all().fetch();
    	render(time);
    }
    
    /**Abre a página de Cadastro de times*/
    public static void timesCadastrar() {
    	render();
    }
    
    /**Carrega o time que se quer editar e manda pra página de edição*/
    public static void timesEditar(long id){
    	TimeFutebol timefutebol = TimeFutebol.find("id", id).first();
		render(timefutebol);
    }
    
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
