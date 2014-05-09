package models;

import java.sql.Date;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Ingresso extends Model{
	public Date dataCompra;
	public String horaCompra;
	
	//chaves estrngeiras
	public int id_usuario;
	public int id_partida;
	public int id_cadeira;
	
	public Ingresso(Date dataCompra, String horaCompra, int id_usuario, int id_partida,
			        int id_cadeira) {
		this.dataCompra = dataCompra;
		this.horaCompra = horaCompra;
		this.id_usuario = id_usuario;
		this.id_partida = id_partida;
		this.id_cadeira = id_cadeira;
	}
}
