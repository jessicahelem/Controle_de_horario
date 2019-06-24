package com.example.controledehorarios.models;

import com.google.gson.annotations.SerializedName;

public class DeclaracaoInteresse {
    @SerializedName("id") private long id;
    @SerializedName("declarador") private Professor declarador;
    @SerializedName("data_declaracao") private String dataDeclaracao;


    public DeclaracaoInteresse(Professor declarador, String dataDeclaracao) {
        this.declarador = declarador;
        this.dataDeclaracao = dataDeclaracao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Professor getDeclarador() {
        return declarador;
    }

    public void setDeclarador(Professor declarador) {
        this.declarador = declarador;
    }

    public String getDataDeclaracao() {
        return dataDeclaracao;
    }

    public void setDataDeclaracao(String dataDeclaracao) {
        this.dataDeclaracao = dataDeclaracao;
    }
}
