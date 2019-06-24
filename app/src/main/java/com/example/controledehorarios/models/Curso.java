package com.example.controledehorarios.models;

import com.google.gson.annotations.SerializedName;

public class Curso {

    @SerializedName("id") private long id;
    @SerializedName("descricao") private String descricao;
    @SerializedName("tipo") private String tipo;


    public Curso(String descricao, String tipo) {
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
