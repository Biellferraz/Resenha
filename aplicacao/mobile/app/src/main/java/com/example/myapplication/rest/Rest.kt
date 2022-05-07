package com.example.myapplication.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Rest {
    //private val baseUrl = "http://10.18.34.103:8080/"
    private val baseUrl = "http://192.168.0.60:8080/" //alterar para o Ip proprio de quem estiver

    fun getInstance(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}