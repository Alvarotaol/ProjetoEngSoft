package models;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;//Importa a anotação Entity (que não sei pra quê serve)

import play.*; //Coloquei pra caso precise
import play.db.jpa.Model; //Classe modelo

@Entity
public class Usuario extends Model {
	
	private static int nUsuario = 0;
	public String nome;
	public String cpf;
	public String email;
	public String endereco;
	public String telefone;
	public Date dNasc;
	
	public Usuario(){
		nome = "Usuário" + nUsuario;
		nUsuario++;
	}
	
	public Usuario(String nome, String cpf, String email, String endereco, String telefone, Date dNasc){
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.dNasc = dNasc;
	}
}