package com.example.controledehorarios.models;

import com.google.gson.annotations.SerializedName;

import java.sql.Time;

public class Horario {

    @SerializedName("id") private long id;
    @SerializedName("dia_semana") private DiaSemana diaSemana ;
    @SerializedName("hora_inicio") private String hora_inicio;
    @SerializedName("hora_fim") private String hora_fim;
    @SerializedName("turma") private Turma turma;


    public Horario( DiaSemana diaSemana, String hora_inicio, String hora_fim, Turma turma) {
        this.id = id;
        this.diaSemana = diaSemana;
        this.hora_inicio = hora_inicio;
        this.hora_fim = hora_fim;
        this.turma = turma;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_fim() {
        return hora_fim;
    }

    public void setHora_fim(String hora_fim) {
        this.hora_fim = hora_fim;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }


    public String toString() {
        return String.valueOf((this.getDiaSemana()));
    }
}


