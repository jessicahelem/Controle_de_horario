package com.example.controledehorarios.models;

import com.google.gson.annotations.SerializedName;

public class Professor {

   @SerializedName("id") private long id;
    @SerializedName("matricula")private String matricula;
   @SerializedName("nome") private String nome;
    @SerializedName("cpf") public String cpf;

    public Professor(String matricula, String nome, String cpf) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String toString() {
        return (this.getNome());
    }
}

