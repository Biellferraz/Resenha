package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TelaCadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro)
    }

    fun login(v: View){
        val telaLogin: Intent = Intent(baseContext,TelaLogin::class.java)

        startActivity(telaLogin)
    }

}