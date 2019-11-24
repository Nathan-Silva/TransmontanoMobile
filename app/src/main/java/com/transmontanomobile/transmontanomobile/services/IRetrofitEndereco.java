package com.transmontanomobile.transmontanomobile.services;


import com.transmontanomobile.transmontanomobile.model.Endereco;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface IRetrofitEndereco {

    @GET("unidademedica/todos")
    Call<List<Endereco>> getEndereco();

    public static final Retrofit retrofit = new Retrofit.Builder().baseUrl(" http://m.trasmontano.srv.br:8888/").addConverterFactory(GsonConverterFactory.create()).build();

}

