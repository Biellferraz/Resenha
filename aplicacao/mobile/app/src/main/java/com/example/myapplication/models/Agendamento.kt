package com.example.myapplication.models

data class Agendamento(
    val fkQuadra: Int,
    val fkJogador: Int,
    val preco: Double,
    var hora_marcada: String
)
