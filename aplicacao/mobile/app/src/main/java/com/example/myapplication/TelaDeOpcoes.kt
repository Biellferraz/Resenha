package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TelaDeOpcoes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_de_opcoes)
    }

//
//    fun modalidadeFutebol(v: View){
//        val telaFut: Intent = Intent(
//            baseContext,
//            TelaFut::class.java
//        )
//        telaFut.putExtra("nome_usuario", "Caio")
//        startActivity(telaFut)
//    }
//    fun modalidadeBasquete(v: View){
//        val telaBasq: Intent = Intent(
//            baseContext,
//            TelaBasq::class.java
//        )
//        telaBasq.putExtra("nome_usuario", "Caio")
//        startActivity(telaBasq)
//    }
//    fun modalidadeTenis(v: View){
//        val telaTenis: Intent = Intent(
//            baseContext,
//            TelaTenis::class.java
//        )
//        telaTenis.putExtra("nome_usuario", "Caio")
//        startActivity(telaTenis)
//    }
//    fun modalidadeVolei(v: View){
//        val telaVolei: Intent = Intent(
//            baseContext,
//            TelaVolei::class.java
//        )
//        telaVolei.putExtra("nome_usuario", "Caio")
//        startActivity(telaVolei)
//    }

}