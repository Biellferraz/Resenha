package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class TelaLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_login)
    }

    fun cadastro(v: View) {
        val telaCadastro: Intent = Intent(baseContext, TelaCadastro::class.java)

        startActivity(telaCadastro)
    }
}