package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.models.AuthRequest
import com.example.myapplication.models.AuthResponse
import com.example.myapplication.rest.Rest
import com.example.myapplication.services.AuthService
import com.example.myapplication.services.Validator
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
        if (!Validator.emailIsFine(et_email.text.toString())) {
            et_email.error = "E-mail inválido"
        } else if (!Validator.passwordIsFine(et_senha.text.toString())) {
            et_senha.error = "Senha inválida"
        } else {
            val request = retrofit.create(AuthService::class.java)

            val authRequest = AuthRequest(
                et_email.text.toString(),
                et_senha.text.toString()
            )


            request.login(authRequest).enqueue(object : Callback<AuthResponse> {


                override fun onResponse(
                    call: Call<AuthResponse>,
                    response: Response<AuthResponse>
                ) {
                    if (response.isSuccessful) {
                        println(response.body()?.token)
                        val editor = getSharedPreferences(
                            "ACESSO", Context.MODE_PRIVATE
                        ).edit()

                        editor.putString("jwt_token", response.body()?.token)
                        editor.apply()

                        startActivity(Intent(baseContext, MainActivity::class.java))
                    } else if (response.code() == 403) {
                        Toast.makeText(
                            baseContext, "Usuario e/ou senha estão incorretos", Toast.LENGTH_LONG
                        )
                    }
                }

                override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                    Toast.makeText(
                        baseContext, t.message, Toast.LENGTH_LONG
                    ).show()
                }


            })
        }
    }

//    fun dd(v: View) {
//
//        val telainicial: Intent = Intent(baseContext, TelaInicial::class.java)
//        val request = retrofit.create(AuthService::class.java)
//
//
//        if (et_email.text.toString().trim().equals("resenha@gmail")
//            && et_senha.text.toString().equals("123456")
//        ) {
//            Toast.makeText(
//                baseContext,
//                et_email.text.toString(),
//                Toast.LENGTH_SHORT
//            ).show()
//
//            tvErro.visibility = View.GONE
//            startActivity(telainicial)
//
//            val authRequest = AuthRequest(
//                et_email.text.toString(),
//                et_senha.text.toString()
//            )
//
//            request.login(authRequest).enqueue(object : Callback<AuthResponse> {
//
//
//                override fun onResponse(
//                    call: Call<AuthResponse>,
//                    response: Response<AuthResponse>
//                ) {
//                    if (response.isSuccessful) {
//                        println(response.body()?.token)
//                        val editor = getSharedPreferences(
//                            "ACESSO", Context.MODE_PRIVATE
//                        ).edit()
//
//                        editor.putString("jwt_token", response.body()?.token)
//                        editor.apply()
//
//                        startActivity(Intent(baseContext, MainActivity::class.java))
//                    } else if (response.code() == 403) {
//                        Toast.makeText(
//                            baseContext, "Usuario e/ou senha estão incorretos", Toast.LENGTH_LONG
//                        )
//                    }
//                }
//
//                override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
//                    Toast.makeText(
//                        baseContext, t.message, Toast.LENGTH_LONG
//                    ).show()
//                }
//
//
//            })
//
//        } else {
//            tvErro.text = "login e/ou senha estão incorretos"
//            tvErro.setTextColor(
//                AppCompatResources.getColorStateList(
//                    baseContext,
//                    R.color.primary_red
//                )
//            )
//            tvErro.visibility = View.VISIBLE
//        }
//
//    }
}