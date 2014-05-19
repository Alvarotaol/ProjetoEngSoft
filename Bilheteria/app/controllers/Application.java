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
    
    public static void indexProxJogos() {
    	render();
    }
    
    
    public static void ingressos() {
    	render();    	
    }
    
    
}