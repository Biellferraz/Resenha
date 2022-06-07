package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class TelaDeOpcoes : AppCompatActivity() {

    var idJogador: String = ""
    var nomeJogador: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_de_opcoes)
         idJogador = intent.getStringExtra("idJogador").toString()
         nomeJogador = intent.getStringExtra("nomeJogador").toString()
    }

    fun tela(v: View) {
        val tela: Intent = Intent(baseContext, Pagamento::class.java)
        startActivity(tela)
    }

    fun modalidadeFutebol(v: View) {
        val tela: Intent = Intent(baseContext,TelaDeQuadras::class.java)
        tela.putExtra("idJogador",idJogador)
        tela.putExtra("nomeJogador",nomeJogador)
        tela.putExtra("modalidade",getString(R.string.futebol))
        startActivity(tela)
    }


    fun modalidadeBasquete(v: View){
        val tela: Intent = Intent(baseContext,TelaDeQuadras::class.java)
        tela.putExtra("idJogador",idJogador)
        tela.putExtra("nomeJogador",nomeJogador)
        tela.putExtra("modalidade",getString(R.string.basquete))
        val tela2: Intent = Intent(baseContext,TelaDeQuadras::class.java)
        tela.putExtra("modalidade",getString(R.string.basquete))
        val tela3: Intent = Intent(baseContext,Agendamento::class.java)
        tela.putExtra("modalidade",getString(R.string.basquete))
        startActivity(tela)
    }

    fun modalidadeTenis(v: View){
        val tela: Intent = Intent(baseContext,TelaDeQuadras::class.java)
        tela.putExtra("idJogador",idJogador)
        tela.putExtra("nomeJogador",nomeJogador)
        tela.putExtra("modalidade",getString(R.string.tenis))
        val tela2: Intent = Intent(baseContext,TelaDeQuadras::class.java)
        tela.putExtra("modalidade",getString(R.string.tenis))
        val tela3: Intent = Intent(baseContext,Agendamento::class.java)
        tela.putExtra("modalidade",getString(R.string.tenis))
        startActivity(tela)
    }

    fun modalidadeVolei(v: View){
        val tela: Intent = Intent(baseContext,TelaDeQuadras::class.java)
        tela.putExtra("idJogador",idJogador)
        tela.putExtra("nomeJogador",nomeJogador)
        tela.putExtra("modalidade",getString(R.string.volei))
        val tela2: Intent = Intent(baseContext,TelaDeQuadras::class.java)
        tela.putExtra("modalidade",getString(R.string.volei))
        val tela3: Intent = Intent(baseContext,Agendamento::class.java)
        tela.putExtra("modalidade",getString(R.string.volei))
        startActivity(tela)
    }

}