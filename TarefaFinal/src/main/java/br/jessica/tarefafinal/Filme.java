/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jessica.tarefafinal;

/**
 *
 * @author Jessica
 */
public class Filme {
    private int id;
    private String titulo;
    private String genero;
    private int ano;
    private int classificao;
    private String diretor;

    public Filme(int id, String titulo, String genero, int ano, int classificao, String diretor) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.ano = ano;
        this.classificao = classificao;
        this.diretor = diretor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getClassificao() {
        return classificao;
    }

    public void setClassificao(int classificao) {
        this.classificao = classificao;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
   
}
