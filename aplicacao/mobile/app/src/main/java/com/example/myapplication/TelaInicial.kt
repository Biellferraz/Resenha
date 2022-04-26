package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class TelaInicial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)
    }

    fun verQuadra(view: View) {
        startActivity(Intent(baseContext, TelaQuadras::class.java))
    }

    fun filtrar(view: View) {
        startActivity(Intent(baseContext, TelaDeOpcoes::class.java))
    }
}