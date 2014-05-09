package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Fileira extends Model{
	public String nome;
	
	//chave estrangeira
	public int id_setor;
	
	public Fileira(String nome, int id_setor) {
		this.nome = nome;
		this.id_setor = id_setor;
	}
	
}
