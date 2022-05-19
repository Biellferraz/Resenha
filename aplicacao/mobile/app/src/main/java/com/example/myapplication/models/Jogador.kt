package com.example.myapplication.models

import java.time.LocalDate

data class Jogador(
    val cpf : String,
    val nome: String,
    val sobrenome: String,
    val data_nasc : LocalDate,
    val cep : String,
    val telefone : String,
    val email : String,
    val senha : String

)