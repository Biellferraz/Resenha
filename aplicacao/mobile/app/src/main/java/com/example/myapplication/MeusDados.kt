package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MeusDados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meus_dados)
    }

    fun salvar(v: View){
        Toast.makeText(
            baseContext,
            "Dados salvos com sucesso",
            Toast.LENGTH_SHORT).show()
        val tela: Intent = Intent(baseContext,SobreNos::class.java)
        startActivity(tela)
    }

}