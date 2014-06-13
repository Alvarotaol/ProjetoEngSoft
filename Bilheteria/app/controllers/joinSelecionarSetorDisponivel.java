package controllers;

public class joinSelecionarSetorDisponivel {
    long id_setor;
    String nomeSetor;
    String preco;

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

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
}
