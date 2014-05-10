package models;

import java.sql.Date;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Ingresso extends Model{
	public Date dataCompra;
	public String horaCompra;
	
	//chaves estrngeiras
	public long id_usuario;
	public long id_evento;
	public long id_cadeira;
	
	public Ingresso(Date dataCompra, String horaCompra, long id_usuario, long id_evento, long id_cadeira) {
		this.dataCompra = dataCompra;
		this.horaCompra = horaCompra;
		this.id_usuario = id_usuario;
		this.id_evento = id_evento;
		this.id_cadeira = id_cadeira;
	}
}
