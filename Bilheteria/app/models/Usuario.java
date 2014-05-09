package models;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;//Importa a anotação Entity (que não sei pra quê serve)

import play.*; //Coloquei pra caso precise
import play.db.jpa.Model; //Classe modelo

@Entity
public class Usuario extends Model {
	
	public String nome;
	public String cpf;
	public String email;
	public String telefone;
	public String login;
	public String senha;
	public String endereco;
	
	public Date dNasc;
	public int tipo;
	public int banido;
	
	public Usuario(String nome, String cpf, String email, String endereco, String telefone, Date dNasc,
			       String login, String senha, int tipo, int banido){
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		
		this.dNasc = dNasc;
		this.tipo = tipo;
		this.banido = banido;
	}
}