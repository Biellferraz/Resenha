package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.models.Jogador
import com.example.myapplication.rest.Rest
import com.example.myapplication.services.QuadraService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TelaDeQuadras : AppCompatActivity() {
    private val retrofit = Rest.getInstance()
    private lateinit var Container: LinearLayout
    private lateinit var etId: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_de_quadras)
        etId = findViewById(R.id.etBusca)
    }


    fun teste(view: View) {
        val id = etId.text.toString().toLong()
        val request = retrofit.create(QuadraService::class.java)
        val prefs = getSharedPreferences("ACESSO", Context.MODE_PRIVATE)
        val token = prefs.getString("jwt_token", "")

        request.getById(id, token).enqueue(object : Callback<Jogador> {
            override fun onResponse(call: Call<Jogador>, response: Response<Jogador>) {
                if (response.isSuccessful) {
                    Container.removeAllViews()
                    val tvMovie = TextView(baseContext)
                    tvMovie.text = response.body()?.nome
                    Container.addView(tvMovie)
                } else {
                    Toast.makeText(
                        baseContext,
                        response.message(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<Jogador>, t: Throwable) {
                Toast.makeText(
                    baseContext,
                    t.message,
                    Toast.LENGTH_LONG
                ).show()
            }

        })
    }
}