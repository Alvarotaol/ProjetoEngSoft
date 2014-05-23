package models;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;

@Entity
public class Estadio extends Model{
	public String nome;
	public String logradouro;
	public String bairro;
	public String cep;
	public String cidade;
	public String estado;
	
	public Estadio(String nome, String logradouro, String bairro, String cidade, String estado, String cep) {
		this.nome = nome;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}
}
