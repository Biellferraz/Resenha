package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Pagamento : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagamento)
    }

    fun pix(v: View){
        val tela: Intent = Intent(baseContext,FeedBack::class.java)
        startActivity(tela)
    }

    fun pagamento(view: View) {
        startActivity(Intent(baseContext, PagamentoDesejavel::class.java))
    }

}