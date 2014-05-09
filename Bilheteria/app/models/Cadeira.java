package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Cadeira extends Model{
	public String nome;
	public int status;
	
	//chave estrangeira
	public int id_setor;
	
	public Cadeira(String nome, int id_setor, int status) {
		this.nome = nome;
		this.id_setor = id_setor;
		this.status = status;
	}
}
