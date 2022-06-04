package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.models.Jogador
import com.example.myapplication.rest.Rest
import com.example.myapplication.services.AuthService

class Agendamento : AppCompatActivity() {
    private val retrofit = Rest.getInstance()

    //    private val valor: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agendamento)
        val nome = intent.getStringExtra("nome")
        val quadra = intent.getStringExtra("quadra")
        val idQuadra = intent.getStringExtra("idQuadra")
        val centro = intent.getStringExtra("centro")
        val modalidade = intent.getStringExtra("modalidade")
        val valor = intent.getStringExtra("valor")
        val dia = intent.getIntExtra("dia", 0)
        val mes = intent.getIntExtra("mes", 0)
        val ano = intent.getIntExtra("ano", 0)
        val horario = intent.getStringExtra("horario")
        findViewById<TextView>(R.id.horaioMarcado).text = "${dia}/${mes}/${ano} às ${horario}"
        findViewById<TextView>(R.id.nomeJogador).text = nome
        findViewById<TextView>(R.id.quadra).text = quadra
        findViewById<TextView>(R.id.centro).text = centro
        findViewById<TextView>(R.id.modalidade).text = modalidade
        findViewById<TextView>(R.id.valor).text = valor


    }

    fun agendar(v: View) {
        val request = retrofit.create(Agendamento::class.java)

        val agendamentoRequest = Agendamento(
            idQ
            val fkQuadra: Int,
            val fkJogador: Int,
            val preco: Double,
            var hora_marcada: String
        )
        val pagamento: Intent = Intent(baseContext, Pagamento::class.java)

//        pagamento.putExtra("valor", valor)

        startActivity(pagamento)
    }
}