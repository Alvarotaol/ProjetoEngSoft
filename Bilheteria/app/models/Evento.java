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
	public Date dataFinalCompra;
	public String hora;
        
        public int disponivel;
	
	public Evento(String desc, long id_estadio, long id_mandante, long id_visitante, Date data, String hora, int disp, Date dataLimite) {
		this.descricao = desc;
		this.dataEvento = data;
		this.hora = hora;
		this.dataFinalCompra = dataLimite;
                this.disponivel = disp;                
		
		//chaves estrangeiras
		this.id_estadio = id_estadio;
		this.id_mandante = id_mandante;
		this.id_visitante = id_visitante;
	}
	
}