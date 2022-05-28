package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapters.QuadraAdapter
import com.example.myapplication.adapters.QuadrasMockAdapter
import com.example.myapplication.models.Quadra
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
        val recylerViewContainer = findViewById<RecyclerView>(R.id.recyclerQuadrasContainer)
        recylerViewContainer.layoutManager = LinearLayoutManager(baseContext)
        val imagem = "https://www.saopaulo.sp.gov.br/wp-content/uploads/2020/10/quadra-adolfo.jpg"
        val quadrasLists = listOf<Quadra>(
        )

        recylerViewContainer.adapter = QuadrasMockAdapter(quadrasLists)
    }


//    fun teste(view: View) {
//        val id = etId.text.toString().toLong()
//        val request = retrofit.create(QuadraService::class.java)
//        val prefs = getSharedPreferences("ACESSO", Context.MODE_PRIVATE)
//        val token = prefs.getString("jwt_token", "")
//
//        request.getById(id, token).enqueue(object : Callback<Jogador> {
//            override fun onResponse(call: Call<Jogador>, response: Response<Jogador>) {
//                if (response.isSuccessful) {
//                    Container.removeAllViews()
//                    val tvMovie = TextView(baseContext)
//                    tvMovie.text = response.body()?.nome
//                    Container.addView(tvMovie)
//                } else {
//                    Toast.makeText(
//                        baseContext,
//                        response.message(),
//                        Toast.LENGTH_LONG
//                    ).show()
//                }
//            }
//
//            override fun onFailure(call: Call<Jogador>, t: Throwable) {
//                Toast.makeText(
//                    baseContext,
//                    t.message,
//                    Toast.LENGTH_LONG
//                ).show()
//            }
//
//        })
//    }

    fun trazerQuadras(){

        val prefs = getSharedPreferences("ACESSO", Context.MODE_PRIVATE)
        val request = retrofit.create(QuadraService::class.java)
        val modalidade = intent.getStringExtra("modalidade")
        val token = prefs.getString("jwt_token", "")

        request.getQuadraPorModalidade(modalidade,token).enqueue(object : Callback<Quadra> {
            override fun onResponse(call: Call<Quadra>, response: Response<Quadra>) {
                if (response.isSuccessful) {
                   QuadraAdapter.QuadraViewHolder()

                } else {
                    Toast.makeText(
                        baseContext,
                        response.message(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }


            override fun onFailure(call: Call<Quadra>, t: Throwable) {
                Toast.makeText(
                    baseContext,
                    t.message,
                    Toast.LENGTH_LONG
                ).show()
            }

        })

    }

    fun verQuadra(view: View) {
        val telaQuadra: Intent = Intent(baseContext, TelaQuadras::class.java)

        telaQuadra

    }
}