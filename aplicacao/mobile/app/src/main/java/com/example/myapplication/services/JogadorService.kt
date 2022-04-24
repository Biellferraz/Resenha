package com.example.myapplication.services

import com.example.myapplication.models.Jogador
import retrofit2.Call
import retrofit2.http.*

interface JogadorService {

    @GET("/jogadores")
    fun list(
        @Header("Authorization") token: String?,
    ): Call<List<Jogador>>

    @GET("/jogadores/{id}")
    fun getById(
        @Path("id") id: Long,
        @Header("Authorization") token: String?,
    ): Call<Jogador>

    @GET("jogadores/{email}/{senha}")
    fun busarPorEmailSenha(
        @Path("email") email: String,
        @Path("senha") senha: String,
        @Header("Authorization") token: String?,
    ): Call<Jogador>

    @DELETE("/jogadores/{id}")
    fun remove(
        @Path("id") id: Long,
        @Header("Authorization") token: String?,
    ): Call<Void>


    @POST("/jogadores")
    fun save(
        @Header("Authorization") token: String?,
    )

    @PUT("/jogadores/{id}")
    fun update(
        @Header("Authorization") token: String?
    )
}