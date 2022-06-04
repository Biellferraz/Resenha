package com.example.myapplication.models

import java.time.LocalDate

data class Jogador(
    val id: String,
    val cpf : String,
    val nome: String,
    val sobrenome: String,
    val data_nasc : String,
    val cep : String,
    val telefone : String,
    val email : String,
    val senha : String

)