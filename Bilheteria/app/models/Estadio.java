package models;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;

@Entity
@Table(name="estadio")
public class Estadio extends Model{
	public String nomeEstadio;
	public String enderecoEstadio;
	
	public Estadio(String nome, String endereco) {
		this.nomeEstadio = nome;
		this.enderecoEstadio = endereco;
	}
}
