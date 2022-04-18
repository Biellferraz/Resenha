package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class PagamentoDesejavel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagamento_desejavel)
    }


    fun home(v: View) {
        val telaOpcoes: Intent = Intent(baseContext, TelaDeOpcoes::class.java)
        startActivity(telaOpcoes)
    }

    fun pagamento(v: View) {
        val pagamento: Intent = Intent(baseContext, Pagamento::class.java)
        startActivity(pagamento)
    }

    fun agendamento(v: View) {
        val agendamento: Intent = Intent(baseContext, Agendamento::class.java)
        startActivity(agendamento)
    }
}