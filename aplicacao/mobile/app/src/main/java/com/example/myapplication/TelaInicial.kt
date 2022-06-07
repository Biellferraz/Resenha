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
        val telaQuadras: Intent = Intent(baseContext, TelaQuadras::class.java)
        val idJogador = intent.getStringExtra("idJogador").toString()
        val nomeJogador = intent.getStringExtra("nomeJogador").toString()
        telaQuadras.putExtra("idJogador",idJogador)
        telaQuadras.putExtra("nomeJogador",nomeJogador)
        startActivity(telaQuadras)
    }

    fun filtrar(view: View) {
        val telaOpcao: Intent = Intent(baseContext, TelaDeOpcoes::class.java)
        val idJogador = intent.getStringExtra("idJogador").toString()
        val nomeJogador = intent.getStringExtra("nomeJogador").toString()
        telaOpcao.putExtra("idJogador",idJogador)
        telaOpcao.putExtra("nomeJogador",nomeJogador)
        startActivity(telaOpcao)
    }
}