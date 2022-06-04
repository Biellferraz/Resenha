package com.example.myapplication.models

data class Agendar(
    val fkQuadra: String,
    val fkJogador: String,
    val preco: String,
    var hora_marcada: String
)
