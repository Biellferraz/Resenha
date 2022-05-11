package com.example.myapplication.models

import java.sql.Date

data class Jogador(
    val cpf : String,
    val nome: String,
    val sobrenome: String,
    val data_nascs : Date,
    val cep : String,
    val telefone : String,
    val email : String,
    val senha : String

)