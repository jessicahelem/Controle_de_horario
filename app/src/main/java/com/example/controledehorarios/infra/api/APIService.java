package com.example.controledehorarios.infra.api;

import com.example.controledehorarios.infra.api.EndPoint.AusenciaEndPoint;
import com.example.controledehorarios.infra.api.EndPoint.TokenEndPoint;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIService {

    public static final String BASE_URL = "http://127.0.0.1:8000/api/";


    public Retrofit retrofit;
    public Interceptor interceptor;

    public TokenEndPoint tokenEndPoint;
    public AusenciaEndPoint ausenciaEndPoint;


    public APIService(String token){
        this.interceptor = new InterceptorAPI("token"+token);


        OkHttpClient.Builder builderCliente = new OkHttpClient.Builder();
        builderCliente.interceptors().add(this.interceptor);
        OkHttpClient cliente = builderCliente.build();

        Retrofit.Builder builder = new Retrofit.Builder();
        retrofit = builder.baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(cliente).build();


        tokenEndPoint = retrofit.create(TokenEndPoint.class);
        ausenciaEndPoint = retrofit.create(AusenciaEndPoint.class);


    }
}
