package controllers;

public class joinCadeirasQueNaoForamCompradas {
    public long id_cadeira;
    public int status;
    public String nomeCadeira;

    public void setStatus(int s) {
        this.status = s;
    }
    
    public int getStatus() {
        return status;
    }
    
    public long getId_cadeira() {
        return id_cadeira;
    }

    public void setId_cadeira(long id_cadeira) {
        this.id_cadeira = id_cadeira;
    }

    public String getNomeCadeira() {
        return nomeCadeira;
    }

    public void setNomeCadeira(String nomeCadeira) {
        this.nomeCadeira = nomeCadeira;
    }
}
