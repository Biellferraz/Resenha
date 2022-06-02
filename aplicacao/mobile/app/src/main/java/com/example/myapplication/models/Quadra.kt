package com.example.myapplication.models

data class Quadra(
    val id: Int,
    val nome: String,
    val centroEsportivo: CentroEsportivo,
    val preco: Double,
    var imagem: String
)