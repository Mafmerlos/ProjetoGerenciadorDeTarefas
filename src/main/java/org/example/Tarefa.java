package org.example;

public class Tarefa {
    private String titulo;
    private String descricao;
    private String prazo;

    public Tarefa(String titulo, String descricao, String prazo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prazo = prazo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPrazo() {
        return prazo;
    }

    @Override
    public String toString() {
        return titulo + ";" + descricao + ";" + prazo;
    }
}
