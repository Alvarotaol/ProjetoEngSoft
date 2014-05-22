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
	public String bairro;
	public String cidade;
	public String estado;
	public boolean banido;
	public Date dataNasc;
	public int tipo;
	
	public Usuario(String nome, String cpf, String email, String endereco, String telefone, Date dataNasc,
			       String login, String senha, int tipo, String bairro, String cidade,
			       String estado){
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.login = login;
		this.senha = senha;
		banido = false; //Esse campo não foi removido do banco. Vai ficar aqui por enquanto
		this.dataNasc = dataNasc;
		this.tipo = tipo;
	}
}