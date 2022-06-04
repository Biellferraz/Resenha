package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.models.Agendar
import com.example.myapplication.rest.Rest
import com.example.myapplication.services.AgendamentoService

class Agendamento : AppCompatActivity() {
    private val retrofit = Rest.getInstance()

    lateinit var nome: String
    lateinit var quadra: String
    lateinit var idQuadra: String
    lateinit var centro: String
    lateinit var modalidade: String
    lateinit var valor: String
    lateinit var hora_marcada: String
    lateinit var idJogador: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agendamento)
        nome = intent.getStringExtra("nome").toString()
        quadra = intent.getStringExtra("quadra").toString()
        idQuadra = intent.getStringExtra("idQuadra").toString()
        centro = intent.getStringExtra("centro").toString()
        modalidade = intent.getStringExtra("modalidade").toString()
        valor = intent.getStringExtra("valor").toString()
        idJogador = intent.getStringExtra("idJogador").toString()
        var dia = intent.getIntExtra("dia", 0)
        var mes = intent.getIntExtra("mes", 0)
        var ano = intent.getIntExtra("ano", 0)
        var horario = intent.getStringExtra("horario").toString()
        hora_marcada = "${dia}/${mes}/${ano}  ${horario}"
        findViewById<TextView>(R.id.horaioMarcado).text = "${dia}/${mes}/${ano} às ${horario}"
        findViewById<TextView>(R.id.nomeJogador).text = nome
        findViewById<TextView>(R.id.quadra).text = quadra
        findViewById<TextView>(R.id.centro).text = centro
        findViewById<TextView>(R.id.modalidade).text = modalidade
        findViewById<TextView>(R.id.valor).text = valor


    }

    fun agendar(v: View) {
        val request = retrofit.create(AgendamentoService::class.java)

        val fkJogador: String = "103"

        val agendamentoRequest = Agendar(
            idQuadra,
            fkJogador,
            valor,
            hora_marcada
        )

        val pagamento: Intent = Intent(baseContext, Pagamento::class.java)


        startActivity(pagamento)
    }
}