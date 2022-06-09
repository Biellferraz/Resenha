package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.load.model.ByteArrayLoader
import com.example.myapplication.models.Agendar
import com.example.myapplication.rest.Rest
import com.example.myapplication.services.AgendamentoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDateTime

class Agendamento : AppCompatActivity() {
    private val retrofit = Rest.getInstance()

    lateinit var nome: TextView
    private var quadraNome: String = ""
    private var idQuadra: String = ""
    private var valor: String = ""
    private var hora_marcada: String = ""
    private var idJogador: String = ""
    private var nomeJogador: String = ""
    private var modalidade: String = ""
    private var centroSportivo: String = ""
    private var horaMarcadaRequest: String= ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agendamento)
        idQuadra = intent.getStringExtra("idQuadra").toString()
        idJogador = intent.getStringExtra("idJogador").toString()
        val dia = intent.getIntExtra("dia",0)
        val mes = intent.getIntExtra("mes",0)
        val ano = intent.getIntExtra("ano",0)
        val horario = intent.getStringExtra("horario").toString()
        hora_marcada = "${dia}/0${mes+1}/${ano} as ${horario}"
        horaMarcadaRequest = "${ano}-0${mes+1}-${dia}T${horario}:00"
        valor = intent.getDoubleExtra("valor", 0.0).toString()
        nomeJogador = intent.getStringExtra("nomeJogador").toString()
        quadraNome = intent.getStringExtra("nomeQuadra").toString()
        centroSportivo = intent.getStringExtra("nomeCentroEsportivo").toString()
        modalidade = intent.getStringExtra("modalidade").toString()
        findViewById<TextView>(R.id.nomeJogador).setText(nomeJogador)
        findViewById<TextView>(R.id.quadra).setText(quadraNome)
        findViewById<TextView>(R.id.centro).setText(centroSportivo)
        findViewById<TextView>(R.id.modalidade).setText(modalidade)
        findViewById<TextView>(R.id.valor).setText(valor)
        findViewById<TextView>(R.id.horaioMarcado).setText(hora_marcada)

    }

    fun agendar(v: View) {
        val request = retrofit.create(AgendamentoService::class.java)


        val agendamentoRequest = Agendar(
            idQuadra,
            idJogador,
            valor,
            horaMarcadaRequest
        )
        request.postAgendamento(agendamentoRequest).enqueue(object : Callback<Agendar> {

            override fun onResponse(
                call: Call<Agendar>,
                response: Response<Agendar>
            ) {
                if (response.code() == 201) {
                    val pagamento: Intent = Intent(baseContext, Pagamento::class.java)
                    startActivity(pagamento)
                } else {
                    Toast.makeText(
                        baseContext, "Erro ao agendar, data invalida", Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<Agendar>, t: Throwable) {
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
