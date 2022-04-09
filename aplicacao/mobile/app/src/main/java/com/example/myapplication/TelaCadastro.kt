package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.Mascaras.MascaraCPF

class TelaCadastro : AppCompatActivity() {
    private lateinit var et_cpf: EditText
    private lateinit var et_telefone: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro)
        et_cpf = findViewById(R.id.et_cpf)
        et_cpf.addTextChangedListener(MascaraCPF.mask("###.###.###-##", et_cpf))
        et_telefone = findViewById(R.id.et_telefone)
        et_telefone.addTextChangedListener(MascaraCPF.mask("(##)#####-####", et_telefone))
    }

    fun login(v: View) {
        val telaLogin: Intent = Intent(baseContext, TelaLogin::class.java)

        startActivity(telaLogin)
    }

}