package com.example.myapplication.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Rest {
    //TROCAR PARA A API FUNCIONAR

    //private val baseUrl = "http://10.18.34.103:8080/"
    private val baseUrl = "http://10.0.0.4:8080/"

    fun getInstance(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}