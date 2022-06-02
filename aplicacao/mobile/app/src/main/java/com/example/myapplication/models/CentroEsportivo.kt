package com.example.myapplication.models

data class CentroEsportivo(
    val cnpj: String,
    val id: Int,
    val cep: String,
    val numero: Int,
    val nome: String,
    val horaAbre: String,
    val horaFecha: String,
    val telefone: String,
    val fkLocatario: Int,
    val cidade: String
)
