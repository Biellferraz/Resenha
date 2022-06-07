package com.example.myapplication.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Rest {
    //TROCAR PARA A API FUNCIONAR
    private val baseUrl = "http://192.168.0.169:8080/"

    fun getInstance(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}