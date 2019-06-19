package com.example.controledehorarios.models;

import java.util.ArrayList;
import java.util.List;

public class Ausencia {
    private long id;
    public String justificativa;
    public Professor professor;
    public Turma turma;
    public boolean faltou;
    public int peso;
    public String data;
    public String horaInicio;
    public String horaFim;





    public Ausencia( String justificativa, String data, String horaInicio) {

        this.justificativa = justificativa;
        /*this.professor = professor;
        this.turma = turma;*/
        this.faltou = faltou;
        /*this.peso = peso;*/
        this.data = data;
        this.horaInicio = horaInicio;

    }




    public Long getId(){
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

    public boolean isFaltou() {
        return faltou;
    }

    public void setFaltou(boolean faltou) {
        this.faltou = faltou;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }


}
