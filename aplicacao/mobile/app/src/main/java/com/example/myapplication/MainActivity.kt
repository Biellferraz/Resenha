package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun login(v: View){
        val telaLogin: Intent = Intent(baseContext,TelaInicial::class.java)

        startActivity(telaLogin)
    }
    fun criarConta(v: View){
        val telaCadastro: Intent = Intent(baseContext,TelaCadastro::class.java)

        startActivity(telaCadastro)
    }

}