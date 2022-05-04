package com.example.myapplication.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Rest {
    //private val baseUrl = "http://10.18.34.103:8080/"
    private val baseUrl = "http://192.168.1.101:8080/" //alterar para o Ip proprio de quem estiver
    // testando seus merda comando para ver o ip =ipconfig

    fun getInstance(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}