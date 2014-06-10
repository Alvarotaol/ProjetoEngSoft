package controllers;

import java.util.Date;

public class joinEventosDisponiveisParaCompra {

    public long getId_evento() {
        return id_evento;
    }

    public void setId_evento(long id_evento) {
        this.id_evento = id_evento;
    }

    public long getId_estadio() {
        return id_estadio;
    }

    public void setId_estadio(long id_estadio) {
        this.id_estadio = id_estadio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getHoraEvento() {
        return horaEvento;
    }

    public void setHoraEvento(String horaEvento) {
        this.horaEvento = horaEvento;
    }

    public String getNomeEstadio() {
        return nomeEstadio;
    }

    public void setNomeEstadio(String nomeEstadio) {
        this.nomeEstadio = nomeEstadio;
    }

    public String getNomeMandante() {
        return nomeMandante;
    }

    public void setNomeMandante(String nomeMandante) {
        this.nomeMandante = nomeMandante;
    }

    public String getNomeVisitante() {
        return nomeVisitante;
    }

    public void setNomeVisitante(String nomeVisitante) {
        this.nomeVisitante = nomeVisitante;
    }

    public String getDataFinalCompra() {
        return dataFinalCompra;
    }

    public void setDataFinalCompra(String dataFinalCompra) {
        this.dataFinalCompra = dataFinalCompra;
    }
    
    long id_evento;
    long id_estadio;
        
    String descricao;
    String nomeEstadio;
    
    String nomeMandante;
    String nomeVisitante;
    
    String dataEvento;
    String dataFinalCompra;
    String horaEvento;
}
