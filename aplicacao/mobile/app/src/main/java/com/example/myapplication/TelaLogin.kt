package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import com.example.myapplication.rest.Rest

class TelaLogin : AppCompatActivity() {
    private lateinit var et_email: EditText;
    private lateinit var et_senha: EditText;
    private lateinit var tvErro: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_login)
        et_email = findViewById(R.id.et_email)
        et_senha = findViewById(R.id.et_senha)
        tvErro = findViewById(R.id.tv_erro)
    }

    fun cadastro(v: View) {
        val telaCadastro: Intent = Intent(baseContext, TelaCadastro::class.java)

        startActivity(telaCadastro)
    }

    fun entrar(v: View){
        val telainicial: Intent = Intent(baseContext,TelaInicial::class.java)


        if (et_email.text.toString().trim().equals("Resenha@Gmail")
            && et_senha.text.toString().equals("123456")){
            Toast.makeText(
                baseContext,
                et_email.text.toString(),
                Toast.LENGTH_SHORT).show()

            tvErro.visibility = View.GONE
            startActivity(telainicial)
        }else {
            tvErro.text = "login e/ou senha estão incorretos"
            tvErro.setTextColor(AppCompatResources.getColorStateList(baseContext, R.color.primary_red))
            tvErro.visibility = View.VISIBLE
        }

    }
}