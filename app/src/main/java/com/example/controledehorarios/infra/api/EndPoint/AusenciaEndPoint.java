package com.example.controledehorarios.infra.api.EndPoint;

import com.example.controledehorarios.models.DeclaracaoAusencia;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AusenciaEndPoint {
    @POST("declaracoes-ausencias/")
    Call<DeclaracaoAusencia> registrarAusencia(@Body DeclaracaoAusencia declaracaoAusencia) ;
    @GET("declaracoes-ausencias/")
    Call<List<DeclaracaoAusencia>> getAusenciaUnica();



}