package com.example.controledehorarios.models;

import com.google.gson.annotations.SerializedName;

public class DeclaracaoAusencia {



    @SerializedName("id") private long id;
    @SerializedName("justificativa") private String justificativa;
    @SerializedName ("professor")private Professor professor;
    @SerializedName("turma") private Turma turma;
    @SerializedName("data_falta") private String data;
    @SerializedName("horario") private Horario horario;
    @SerializedName("data_declaracao")private String dataDeclaracao;


    public DeclaracaoAusencia(String justificativa, String data, Horario horario, String dataDeclaracao,Turma turma,Professor professor) {
        this.justificativa = justificativa;
        this.professor = professor;
        this.turma = turma;
        this.data = data;
        this.horario = horario;
        this.dataDeclaracao = dataDeclaracao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public String getDataDeclaracao() {
        return dataDeclaracao;
    }

    public void setDataDeclaracao(String dataDeclaracao) {
        this.dataDeclaracao = dataDeclaracao;
    }
}