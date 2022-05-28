package com.example.myapplication.models

data class CentroEsportivo(
    val cnpj: String,
    val cep: String,
    val numero: Int,
    val nome: String,
    val hora_abre: String,
    val hora_fecha: String,
    val telefone: String,
    val fkLocatario: Int,
    val fkCidade: String

)
