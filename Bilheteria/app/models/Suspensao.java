package models;

import java.util.Date;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Suspensao extends Model {
	int id_usuario;
	public Date termino;
	
	public Suspensao(int id_usuario, Date termino) {
		this.termino = termino;
		this.id_usuario = id_usuario;
	}
}