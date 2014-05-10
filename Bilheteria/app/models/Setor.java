package models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;

import play.db.jpa.Model;

@Entity
public class Setor extends Model{
	public String nome;
	
	//chave estrangeira
	//@JoinColumn(name="estadio", referencedColumnName="id")
	public long id_estadio;
	
	public Setor (String nome, long id_estadio) {
		this.nome = nome;
		this.id_estadio = id_estadio;
	}
}
