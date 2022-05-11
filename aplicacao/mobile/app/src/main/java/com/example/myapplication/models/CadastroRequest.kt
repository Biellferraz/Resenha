package com.example.myapplication.models

import java.util.*

data class CadastroRequest(
    val cpf : String,
    val nome: String,
    val sobrenome: String,
    val data_nascs : String,
    val cep : String,
    val telefone : String,
    val email : String,
    val senha : String
)
