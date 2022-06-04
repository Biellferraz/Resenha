package com.example.myapplication.services

import com.example.myapplication.models.AuthRequest
import com.example.myapplication.models.AuthResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AgendamentoService {
    @POST("/agendamentos")
    fun postAgendamento(@Body authRequest: AuthRequest): Call<AuthResponse>


}