package com.example.myapplication.models

data class Quadra(
    val id: Int,
    val modalidade: String,
    val numero_quadra: Int,
    val disponivel: Int,
    val fkCentroEsportivo: Int,
    val preco: Double,
    val imagem: String
)