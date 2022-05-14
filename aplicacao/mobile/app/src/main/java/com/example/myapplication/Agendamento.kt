package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Agendamento : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agendamento)
        val nome = intent.getStringExtra("nome")
        val dia = intent.getIntExtra("dia", 0)
        val mes = intent.getIntExtra("mes", 0)
        val ano = intent.getIntExtra("ano", 0)
        val horario = intent.getStringExtra("horario")
        findViewById<TextView>(R.id.horaioMarcado).text = "${dia}/${mes}/${ano} às ${horario}"
        findViewById<TextView>(R.id.nomeJogador).text = nome
        findViewById<TextView>(R.id.quadra).text = nome
        findViewById<TextView>(R.id.centro).text = nome
        findViewById<TextView>(R.id.horaioMarcado).text = nome
        findViewById<TextView>(R.id.modalidade).text = nome
        findViewById<TextView>(R.id.valor).text = nome


    }

    fun agendar(v: View) {
        val pagamento: Intent = Intent(baseContext, Pagamento::class.java)

        startActivity(pagamento)
    }
}