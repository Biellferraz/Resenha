package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapters.QuadraAdapter
import com.example.myapplication.models.Quadra
import com.example.myapplication.rest.Rest
import com.example.myapplication.services.QuadraService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TelaDeQuadras : AppCompatActivity() {
    private val retrofit = Rest.getInstance()
    private lateinit var recyclerViewContainer: RecyclerView
    private var imagem:String = ""
    private var idJogador:String =""
    private var nomeJogador:String =""
    private var modalidade:String = ""
    private var nomeQuadra:String = ""
    private var idQuadra:String = ""
    private var nomeCentroEsportivo:String =""
    private var localizacao:String = ""
    private var preco:Double = 0.0

   // telaQuadra.putExtra("idQuadra", id)
   // telaQuadra.putExtra("imagem", imagem)
    //telaQuadra.putExtra("nomeQuadra", nomeQuadra)
    //telaQuadra.putExtra("nomeCentroEsportivo", nomeCentroEsportivo)
    //telaQuadra.putExtra("localizacao", localizacao)
   // telaQuadra.putExtra("nomeJogador",nomeJogador)
    //telaQuadra.putExtra("idJogador",idJogador)
   // telaQuadra.putExtra("modalidade",modalidade)
    //telaQuadra.putExtra("valor",preco)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         idJogador = intent.getStringExtra("idJogador").toString()
         nomeJogador = intent.getStringExtra("nomeJogador").toString()
         modalidade = intent.getStringExtra("modalidade") ?: "Futebol"
        setContentView(R.layout.activity_tela_de_quadras)
        recyclerViewContainer = findViewById(R.id.recyclerQuadrasContainer)
        recyclerViewContainer.layoutManager = LinearLayoutManager(baseContext)
        findViewById<TextView>(R.id.etModalidade).text = intent.getStringExtra("modalidade")
         imagem = "https://www.saopaulo.sp.gov.br/wp-content/uploads/2020/10/quadra-adolfo.jpg"
        trazerQuadras(imagem)

    }

    fun trazerQuadras(imagem: String) {

        val prefs = getSharedPreferences("ACESSO", Context.MODE_PRIVATE)
        val request = retrofit.create(QuadraService::class.java)
        val modalidade = intent.getStringExtra("modalidade") ?: "Futebol"
        val token = prefs.getString("jwt_token", "")

        request.getQuadraPorModalidade(modalidade, token).enqueue(object : Callback<List<Quadra>> {
            override fun onResponse(call: Call<List<Quadra>>, response: Response<List<Quadra>>) {
                if (response.isSuccessful) {
                    val quadrasList = mutableListOf<Quadra>()

                    response.body()?.forEach { quadra ->
                        quadra.imagem = imagem
                        quadrasList.add(quadra)
                        verQuadra(quadra.id,quadra.imagem,quadra.nome, quadra.centroEsportivo.nome,
                            quadra.centroEsportivo.cidade,quadra.preco)
                    }

                    recyclerViewContainer.adapter = QuadraAdapter(quadrasList)
                }
            }

            override fun onFailure(call: Call<List<Quadra>>, t: Throwable) {
                t.printStackTrace()
                Log.e("api", t.message.toString())
                Log.e("api", t.cause?.message.toString())
                Toast.makeText(
                    baseContext, t.message, Toast.LENGTH_LONG
                ).show()
            }


        })

    }

    fun verQuadra(id: Int, imagem: String,nomeQuadra: String, nomeCentroEsportivo: String, localizacao: String, preco: Double) {

        idQuadra = id.toString()
        this.imagem = imagem
        this.nomeQuadra = nomeQuadra
        this.nomeCentroEsportivo =nomeCentroEsportivo
        this.localizacao = localizacao
        this.preco = preco

    }

    fun irParaQuadra(v:View){
        val telaQuadra: Intent = Intent(baseContext, TelaQuadras::class.java)
        telaQuadra.putExtra("idQuadra", idQuadra)
        telaQuadra.putExtra("imagem", imagem)
        telaQuadra.putExtra("nomeQuadra", nomeQuadra)
        telaQuadra.putExtra("nomeCentroEsportivo", nomeCentroEsportivo)
        telaQuadra.putExtra("localizacao", localizacao)
        telaQuadra.putExtra("nomeJogador",nomeJogador)
        telaQuadra.putExtra("idJogador",idJogador)
        telaQuadra.putExtra("modalidade",modalidade)
        telaQuadra.putExtra("valor",preco)
        startActivity(telaQuadra)
    }
}