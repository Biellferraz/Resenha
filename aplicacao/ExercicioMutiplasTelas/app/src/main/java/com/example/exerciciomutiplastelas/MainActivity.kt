package com.example.exerciciomutiplastelas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources

class MainActivity : AppCompatActivity() {
    private lateinit var etUsuario: EditText
    private lateinit var etSenha: EditText
    private lateinit var tvErro: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etUsuario = findViewById(R.id.et_email)
        etSenha = findViewById(R.id.et_password)
        tvErro = findViewById(R.id.tv_erro)
    }


    fun entrar(v: View){
        if (etUsuario.text.toString().trim().equals("admin@admin.com") && etSenha.text.toString().equals("123456")){
            Toast.makeText(
                baseContext,
                etUsuario.text.toString(),
                Toast.LENGTH_SHORT).show()
        }else {
            tvErro.text = "login e/ou senha estão incorretos"
            tvErro.setTextColor(AppCompatResources.getColorStateList(baseContext, R.color.red))
        }
    }

    fun cadastrar(v: View){
        val cadastro: Intent = Intent(baseContext,Cadastro::class.java)

        cadastro.putExtra("nome_usuario",etUsuario.text.toString())
        cadastro.putExtra("senha_usuario",etSenha.text.toString())

        startActivity(cadastro)

    }
}