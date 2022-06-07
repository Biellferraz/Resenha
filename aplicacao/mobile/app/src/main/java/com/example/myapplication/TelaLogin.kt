package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.models.AuthRequest
import com.example.myapplication.models.AuthResponse
import com.example.myapplication.models.Jogador
import com.example.myapplication.models.Quadra
import com.example.myapplication.rest.Rest
import com.example.myapplication.services.AuthService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TelaLogin : AppCompatActivity() {
    private val retrofit = Rest.getInstance()
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


    fun entrar(view: View) {
//        if (!Validator.emailIsFine(et_email.text.toString())) {
//            et_email.error = "E-mail inválido"
//        } else if (!Validator.passwordIsFine(et_senha.text.toString())) {
//            et_senha.error = "Senha inválida"
//        } else {
        val request = retrofit.create(AuthService::class.java)

        val authRequest = AuthRequest(
            et_email.text.toString(),
            et_senha.text.toString()
        )






        request.postLogin(authRequest).enqueue(object : Callback<Jogador> {


            override fun onResponse(call: Call<Jogador>, response: Response<Jogador>) {
                if (response.isSuccessful) {

                    val inicial: Intent = Intent(baseContext, TelaInicial::class.java)


                    val id = response.body()?.id
                    val nome = response.body()?.nome +(" ") + response.body()?.sobrenome

                    inicial.putExtra("idJogador",id)
                    inicial.putExtra("nomeJogador",nome)

                    val editor = getSharedPreferences(
                        "DadosJogador", Context.MODE_PRIVATE
                    ).edit()

                    editor.putString("nomeJogador", nome)
                    editor.putString("idJogador", id)
                    editor.apply()


                    startActivity(inicial)


                } else if (response.code() == 403) {
                    Toast.makeText(
                        baseContext, "Usuario e/ou senha estÃ£o incorretos", Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(
                        baseContext, "Falha de login", Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<Jogador>, t: Throwable) {
                t.printStackTrace()
                Log.e("api", t.message.toString())
                Log.e("api", t.cause?.message.toString())
                Toast.makeText(
                    baseContext, t.message, Toast.LENGTH_LONG
                ).show()
            }


        })
    }

}