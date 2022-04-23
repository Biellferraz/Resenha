package com.example.myapplication.services

import com.example.myapplication.models.Jogador
import retrofit2.Call
import retrofit2.http.*

interface QuadraService {
    @GET("/jogador")
    fun list(
        @Header("Authorization") token: String?,
    ): Call<List<Jogador>>

    @GET("/jogador/{id}")
    fun getById(
        @Path("id") id: Long,
        @Header("Authorization") token: String?,
    ): Call<Jogador>

    @DELETE("/jogador/{id}")
    fun remove(
        @Path("id") id:Long,
        @Header("Authorization") token: String?,
    ): Call<Void>


    @POST("/jogador")
    fun save(
        @Header("Authorization") token:String?,
    )

    @PUT("/jogador/{id}")
    fun update (@Header("Authorization")token: String?
    )
}