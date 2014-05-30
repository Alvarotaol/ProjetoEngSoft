package models;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;//Importa a anotação Entity (que não sei pra quê serve)

import play.*; //Coloquei pra caso precise
import play.db.jpa.Model; //Classe modelo

@Entity
public class Evento extends Model {
	
	//chaves estrangeiras
	public long id_estadio;
	public long id_mandante;
	public long id_visitante;

	//informações da partida
	public String descricao;
	public Date dataEvento;
	public String hora;

	//public Date dataExpiraCompraDeIngresso;
	//public String horaExpiraCompraDeIngressos;
	
	public Evento(String desc, long id_estadio, long id_mandante, long id_visitante, Date data, String hora) {
		this.descricao = desc;
		this.dataEvento = data;
		this.hora = hora;
		//this.dataExpiraCompraDeIngresso = data2;
		//this.horaExpiraCompraDeIngressos = hora2;
		
		//chaves estrangeiras
		this.id_estadio = id_estadio;
		this.id_mandante = id_mandante;
		this.id_visitante = id_visitante;
	}
	
}