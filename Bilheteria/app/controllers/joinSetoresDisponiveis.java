package controllers;

public class joinSetoresDisponiveis {

    public long getId_setor() {
        return id_setor;
    }

    public void setId_setor(long id_setor) {
        this.id_setor = id_setor;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    public long id_setor;
    public String nomeSetor;
    public int status;
    public float valor; 
    
}
