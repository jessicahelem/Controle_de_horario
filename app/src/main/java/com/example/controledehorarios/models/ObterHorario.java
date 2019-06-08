package com.example.controledehorarios.models;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class ObterHorario {

    private long id;
    public Professor declaradorProfessor;
    public Ausencia ausencia;
    public int peso;
    public boolean status;

    public ObterHorario(long id, Professor declaradorProfessor, Ausencia ausencia, int peso, boolean status) {
        this.id = id;
        this.declaradorProfessor = declaradorProfessor;
        this.ausencia = ausencia;
        this.peso = peso;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Professor getDeclaradorProfessor() {
        return declaradorProfessor;
    }

    public void setDeclaradorProfessor(Professor declaradorProfessor) {
        this.declaradorProfessor = declaradorProfessor;
    }

    public Ausencia getAusencia() {
        return ausencia;
    }

    public void setAusencia(Ausencia ausencia) {
        this.ausencia = ausencia;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}