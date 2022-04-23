package com.example.myapplication.services

import android.telecom.Call
import com.example.myapplication.models.AuthRequest
import com.example.myapplication.models.AuthResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("auth/login")
    fun login(@Body authRequest: AuthRequest):retrofit2.Call<AuthResponse>

}