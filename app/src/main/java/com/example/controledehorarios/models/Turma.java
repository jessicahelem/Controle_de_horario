package com.example.controledehorarios.models;

public class Turma {

    private long id;
    public Professor ministrante;
    public Disciplina disciplina;
    public int cargaHorario;
    public Curso curso;
    public String especificacao;
    public String previsaoTermino;
    public String terminoPeriodo;


    public Turma(long id, Professor ministrante, Disciplina disciplina, int cargaHorario, Curso curso, String especificacao, String previsaoTermino, String terminoPeriodo) {
        this.id = id;
        this.ministrante = ministrante;
        this.disciplina = disciplina;
        this.cargaHorario = cargaHorario;
        this.curso = curso;
        this.especificacao = especificacao;
        this.previsaoTermino = previsaoTermino;
        this.terminoPeriodo = terminoPeriodo;
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

    public String getPrevisaoTermino() {
        return previsaoTermino;
    }

    public void setPrevisaoTermino(String previsaoTermino) {
        this.previsaoTermino = previsaoTermino;
    }

    public String getTerminoPeriodo() {
        return terminoPeriodo;
    }

    public void setTerminoPeriodo(String terminoPeriodo) {
        this.terminoPeriodo = terminoPeriodo;
    }

}
