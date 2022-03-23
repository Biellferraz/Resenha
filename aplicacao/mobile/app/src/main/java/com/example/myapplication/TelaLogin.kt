package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TelaLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_login)
    }
    fun cadastro(v: View){
        val telaCadastro: Intent = Intent(baseContext,TelaCadastro::class.java)

        startActivity(telaCadastro)
    }
}