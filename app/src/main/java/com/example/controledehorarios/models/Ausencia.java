package com.example.controledehorarios.models;
import java.sql.Time;
import java.util.Date;

public class Ausencia {
    private long id;
    public String justificativa;
    public Professor professor;
    public Turma turma;
    public boolean faltou;
    public int peso;
    public Date data;
    public Time horaInicio;
    public Time horaFim;

    public Ausencia(long id, String justificativa, Professor professor, Turma turma, boolean faltou, int peso, Date data, Time horaInicio, Time horaFim) {
        this.id = id;
        this.justificativa = justificativa;
        this.professor = professor;
        this.turma = turma;
        this.faltou = faltou;
        this.peso = peso;
        this.data = data;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Time horaFim) {
        this.horaFim = horaFim;
    }


}
