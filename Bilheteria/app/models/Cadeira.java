package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Cadeira extends Model{
	public String nome;
	public int status;
	
	//chave estrangeira
	public long id_fileira;
	
	public Cadeira(String nome, long id_fileira, int status) {
		this.nome = nome;
		this.id_fileira = id_fileira;
		this.status = status;
	}
}
