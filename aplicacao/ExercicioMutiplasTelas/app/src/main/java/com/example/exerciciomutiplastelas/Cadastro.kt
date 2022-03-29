package com.example.exerciciomutiplastelas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources

class Cadastro : AppCompatActivity() {
    private lateinit var etEmail: EditText
    private lateinit var etSenha: EditText
    private lateinit var etConfirmar: EditText
    private lateinit var tvErro: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        findViewById<TextView>(R.id.et_email).text = intent.getStringExtra("nome_usuario")
        findViewById<TextView>(R.id.et_password).text = intent.getStringExtra("senha_usuario")

        etEmail = findViewById(R.id.et_email)
        etSenha = findViewById(R.id.et_password)
        etConfirmar = findViewById(R.id.et_confirme_password)
        tvErro = findViewById(R.id.tv_erro)
    }

    fun camposValidos(etEmail: EditText, etSenha: EditText, etConfirmar: EditText): Boolean{
        if (etEmail.text.toString().isEmpty()){
            etEmail.error = "Campo não pode estar vazio!"
            return false
        }
        else if (etSenha.text.toString().isEmpty()) {
            etSenha.error = "Campo não pode estar vazio"
            return false
        }
        else if (etConfirmar.text.toString().isEmpty()) {
            etConfirmar.error = "Campo não pode estar vazio"
            return false
        }
        else if(!etSenha.equals(etConfirmar)){
            tvErro.text ="Senhas não conferem"
            tvErro.setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.red))
        }
        return true
    }

    fun cadastrar(v: View){
        if (camposValidos(etEmail,etSenha,etConfirmar)) {
            Toast.makeText(
                baseContext,
                etEmail.text.toString(),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun voltar(v: View){
        val telaLogin: Intent = Intent(baseContext,MainActivity::class.java)

        startActivity(telaLogin)
    }
}