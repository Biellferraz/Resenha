package com.example.myapplication.services

import com.example.myapplication.models.AuthResponse
import com.example.myapplication.models.Jogador
import com.example.myapplication.models.Quadra
import retrofit2.Call
import retrofit2.http.*

interface QuadraService {

    @GET("Quadra/modalidade-quadra/{modalidade}")
    fun getQuadraPorModalidade(@Path("Modalidade")Modalidade :String?,
                               @Header("Authorization") token: String?): Call<Quadra>


}