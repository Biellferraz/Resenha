package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class TelaDeOpcoes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_de_opcoes)
    }

    fun tela(v: View) {
        val tela: Intent = Intent(baseContext, Pagamento::class.java)
        startActivity(tela)
    }


    fun modalidadeFutebol(v: View) {
        startActivity(Intent(baseContext, TelaDeQuadras::class.java))
    }


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