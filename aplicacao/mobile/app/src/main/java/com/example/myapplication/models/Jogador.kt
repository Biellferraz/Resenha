package com.example.myapplication.models

import java.sql.Date

data class Jogador(
    val idJogador: Long,
    val nome: String,
    val sobrenome: String,
    val cpf : String,
    val cep : String,
    val telefone : String,
    val email : String,
    val senha : String,
    val dataNasc : Date,
    val imageUrl: String,
    val productionCost: String,
)