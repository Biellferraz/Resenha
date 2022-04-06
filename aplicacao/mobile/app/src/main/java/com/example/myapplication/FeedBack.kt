package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class FeedBack : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback_app)
    }

    fun avaliar(v: View){
        Toast.makeText(
            baseContext,
            "Mensagem enviada!\n   Obrigado",
            Toast.LENGTH_SHORT).show()
        val tela: Intent = Intent(baseContext,MeusDados::class.java)
        startActivity(tela)
    }
}