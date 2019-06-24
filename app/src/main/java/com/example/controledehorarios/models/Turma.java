package com.example.controledehorarios.models;

import com.google.gson.annotations.SerializedName;

public class Turma {

    @SerializedName("id") private long id;
    @SerializedName("ministrante") private Professor ministrante;
    @SerializedName("disciplina") private Disciplina disciplina;
    @SerializedName("carga_horaria") private int cargaHorario;
    @SerializedName("curso") private Curso curso;
    @SerializedName("especificacao_disciplina") private String especificacao;


    public Turma( Professor ministrante, Disciplina disciplina, int cargaHorario, Curso curso, String especificacao) {
        this.ministrante = ministrante;
        this.disciplina = disciplina;
        this.cargaHorario = cargaHorario;
        this.curso = curso;
        this.especificacao = especificacao;


    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Professor getMinistrante() {
        return ministrante;
    }

    public void setMinistrante(Professor ministrante) {
        this.ministrante = ministrante;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public int getCargaHorario() {
        return cargaHorario;
    }

    public void setCargaHorario(int cargaHorario) {
        this.cargaHorario = cargaHorario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }


    public String toString() {
        return (this.getEspecificacao());
    }
}
