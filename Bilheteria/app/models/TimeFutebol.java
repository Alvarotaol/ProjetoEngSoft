package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class TimeFutebol extends Model {
	public String nomeTime;
	public String cnpjTime;
	public int anoFundacao;
	
	public TimeFutebol(String nome, String cnpj, int ano) {
		this.nomeTime = nome;
		this.cnpjTime = cnpj;
		this.anoFundacao = ano;
	}
}