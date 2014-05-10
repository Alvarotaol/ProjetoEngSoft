package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Fileira extends Model{
	public String nome;
	
	//chave estrangeira
	public long id_setor;
	
	public Fileira(String nome, long id_setor) {
		this.nome = nome;
		this.id_setor = id_setor;
	}
	
}
