package models;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;//Importa a anotação Entity (que não sei pra quê serve)

import play.*; //Coloquei pra caso precise
import play.db.jpa.Model; //Classe modelo


@Entity
public class Evento extends Model {
	//Por enquanto só o nome
	private static int nEvento = 0;
	private String nome;
	private Date data;
	private int quantidade;
	//private Time hora;
	
	public Evento(){
		nome = "Evento" + nEvento;
		nEvento++;
	}
	
	public Evento(String nome, Date data/*, Time hora*/, int quantidade){
		this.nome = nome;
		this.data = data;
		//this.hora = hora;
		this.quantidade = quantidade;
	}
	
}