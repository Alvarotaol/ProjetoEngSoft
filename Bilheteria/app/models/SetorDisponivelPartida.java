package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class SetorDisponivelPartida extends Model{
	public int status;
	
	//chaves estrangeiras
	public long id_evento;
	public long id_setor;
	public float valor;
	
	public SetorDisponivelPartida (int status, long id_evento, long id_setor, float valor) {
                this.status = status;
		this.id_evento = id_evento;
		this.id_setor = id_setor;
		this.valor = valor;
	}
}
