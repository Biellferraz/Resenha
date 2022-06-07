package com.example.myapplication.services

import com.example.myapplication.models.AuthRequest
import com.example.myapplication.models.AuthResponse
import com.example.myapplication.models.Jogador
import com.example.myapplication.models.Quadra
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthService {

    @POST("/jogadores/login")
    fun postLogin(@Body authRequest: AuthRequest): Call<Jogador>

    @POST("/jogadores/cadastrar")
    fun postCadastrar(@Body cadastroRequest: Jogador): Call<AuthResponse>

    @GET("/jogadores/buscarIdPorLogin/{email}/{senha}")
    fun getIdUsuariosPorLogin(
        @Path("email") Email: String?,
        @Path("senha") Senha: String?
    ): Call<Jogador>


}