package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class SetorDisponivelPartida extends Model{
	public int status;
	
	//chaves estrangeiras
	public int id_patida;
	public int id_setor;
	public float valor;
	
	public SetorDisponivelPartida (int status, int id_partida, int id_setor, float valor) {
		this.status = status;
		this.id_patida = id_partida;
		this.id_setor = id_setor;
		this.valor = valor;
	}
}
