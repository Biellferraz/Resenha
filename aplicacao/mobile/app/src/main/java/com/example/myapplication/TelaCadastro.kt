package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.Mascaras.MascaraCPF
import com.example.myapplication.models.AuthResponse
import com.example.myapplication.models.Jogador
import com.example.myapplication.rest.Rest
import com.example.myapplication.services.AuthService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class TelaCadastro : AppCompatActivity() {
    private val retrofit = Rest.getInstance()

    private lateinit var et_cpf: EditText
    private lateinit var et_nome: EditText
    private lateinit var et_sobrenome: EditText
    private lateinit var et_dataNasc: EditText
    private lateinit var et_cep: EditText
    private lateinit var et_telefone: EditText
    private lateinit var et_email: EditText
    private lateinit var et_senha: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro)
        et_cpf = findViewById(R.id.et_cpf)
        et_cpf.addTextChangedListener(MascaraCPF.mask("###.###.###-##", et_cpf))
        et_nome = findViewById(R.id.et_nome)
        et_sobrenome = findViewById(R.id.et_sobrenome)
        et_dataNasc = findViewById(R.id.et_data_nasc)
        et_dataNasc.addTextChangedListener(MascaraCPF.mask("##/##/####", et_dataNasc))
        et_cep = findViewById(R.id.et_cep)
        et_cep.addTextChangedListener(MascaraCPF.mask("#####-###", et_cep))
        et_telefone = findViewById(R.id.et_telefone)
        et_telefone.addTextChangedListener(MascaraCPF.mask("(##)#####-####", et_telefone))
        et_email = findViewById(R.id.et_email)
        et_senha = findViewById(R.id.et_senha)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun criar(v: View) {

        val request = retrofit.create(AuthService::class.java)
        val checkBox = findViewById<CheckBox>(R.id.checkBoxTermos).isChecked

        val idJogador: String = ""

        val cadastroRequest = Jogador(
            idJogador.toString(),
            et_cpf.text.toString(),
            et_nome.text.toString(),
            et_sobrenome.text.toString(),
            et_dataNasc.text.toString(),
            et_cep.text.toString(),
            et_telefone.text.toString(),
            et_email.text.toString(),
            et_senha.text.toString()
        )

        if(checkBox) {

            request.postCadastrar(cadastroRequest).enqueue(object : Callback<AuthResponse> {
                override fun onResponse(
                    call: Call<AuthResponse>,
                    response: Response<AuthResponse>
                ) {
                    if (response.code() == 201) {
                        val telaLogin: Intent = Intent(baseContext, TelaLogin::class.java)
                        startActivity(telaLogin)
                    } else {
                        Toast.makeText(
                            baseContext, "Erro ao cadastrar", Toast.LENGTH_LONG
                        ).show()
                    }
                }

                override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                    t.printStackTrace()
                    Log.e("api", t.message.toString())
                    Log.e("api", t.cause?.message.toString())
                    Toast.makeText(
                        baseContext, t.message, Toast.LENGTH_LONG
                    ).show()
                }
            })
        }
        else {
            Toast.makeText(
                baseContext, "Para prosseguir você deve aceitar os termos!", Toast.LENGTH_LONG
            ).show()
    }

    }



    fun termos(v: View){
        val telaTermos: Intent = Intent(baseContext, TelaDeTermos::class.java)

        startActivity(telaTermos)

    }

    fun login(v: View) {
        val telaLogin: Intent = Intent(baseContext, TelaLogin::class.java)

        startActivity(telaLogin)
    }

}