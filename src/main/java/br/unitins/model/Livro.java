package br.unitins.model;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Livro extends PanacheEntity{
    private String nome;
    private String corCapa;
    private String genero;
    private String dataLanc;
    private String autor;
   
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCorCapa() {
        return corCapa;
    }
    public void setCorCapa(String corCapa) {
        this.corCapa = corCapa;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getDataLanc() {
        return dataLanc;
    }
    public void setDataLanc(String dataLanc) {
        this.dataLanc = dataLanc;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    
}
