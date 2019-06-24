package com.example.controledehorarios.models;

import com.google.gson.annotations.SerializedName;

public class AusenciaInteresse {

    @SerializedName("id") private long id;
    @SerializedName("ausencia") private DeclaracaoAusencia ausencia;
    @SerializedName("hora_inicio") private String horaInicio;
    @SerializedName("hora_fim") private String horaFim;
    @SerializedName("status") private boolean status;
    @SerializedName("interessado") private DeclaracaoInteresse interessado;

    public AusenciaInteresse(DeclaracaoAusencia ausencia, String horaInicio, String horaFim, boolean status, DeclaracaoInteresse interessado) {
        this.ausencia = ausencia;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.status = status;
        this.interessado = interessado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
   }

    public DeclaracaoAusencia getAusencia() {
        return ausencia;
    }

    public void setAusencia(DeclaracaoAusencia ausencia) {
        this.ausencia = ausencia;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public DeclaracaoInteresse getInteressado() {
        return interessado;
    }

    public void setInteressado(DeclaracaoInteresse interessado) {
        this.interessado = interessado;
    }
}
