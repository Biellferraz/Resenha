package com.example.myapplication

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import java.io.InputStream
import java.net.URL
import java.util.*


class TelaQuadras : AppCompatActivity() {
    private lateinit var calendario: CalendarView

    private var dia: Int = 0
    private var mes: Int = 0
    private var ano: Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_quadras)
        calendario = findViewById(R.id.calendar)
        configurarCalendario()
        val imagemQuadra = intent.getStringExtra("imagem").toString()
        val nomeQuadra = intent.getStringExtra("nomeQuadra").toString()
        val nomeCentroEsportivo = intent.getStringExtra("nomeCentroEsportivo").toString()
        val localizacaoQuadra = intent.getStringExtra("localizacao").toString()
        val preco = intent.getDoubleExtra("valor",0.0).toString()
        findViewById<TextView>(R.id.centro).text = nomeCentroEsportivo
        findViewById<TextView>(R.id.nomeQuadra).text = nomeQuadra
        findViewById<TextView>(R.id.endereco).text = localizacaoQuadra
        findViewById<TextView>(R.id.preco).text = "Valor por hora R$${preco}"
       // findViewById<ImageView>(R.id.imagemQuadra) = imagemQuadra
    }

    private fun configurarCalendario() {
        val calendar = Calendar.getInstance()
        calendario.setOnDateChangeListener { view, year, month, dayOfMonth ->
            dia = dayOfMonth
            mes = month
            ano = year
            calendar.set(year, month, dayOfMonth)
        }
    }

    private var horario: String = ""

    fun horario1(v: View) {
        horario = getString(R.string.horario1)
        findViewById<TextView>(R.id.horario1).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_red
            )
        )
        findViewById<TextView>(R.id.horario2).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario3).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario4).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario5).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario6).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario7).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario8).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario9).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
    }

    fun horario2(v: View) {
        horario = getString(R.string.horario2)
        findViewById<TextView>(R.id.horario1).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario2).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_red
            )
        )
        findViewById<TextView>(R.id.horario3).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario4).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario5).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario6).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario7).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario8).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario9).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
    }

    fun horario3(v: View) {
        horario = getString(R.string.horario3)
        findViewById<TextView>(R.id.horario1).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario2).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario3).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_red
            )
        )
        findViewById<TextView>(R.id.horario4).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario5).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario6).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario7).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario8).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario9).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
    }

    fun horario4(v: View) {
        horario = getString(R.string.horario4)
        findViewById<TextView>(R.id.horario1).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario2).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario3).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario4).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_red
            )
        )
        findViewById<TextView>(R.id.horario5).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario6).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario7).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario8).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario9).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
    }

    fun horario5(v: View) {
        horario = getString(R.string.horario5)
        findViewById<TextView>(R.id.horario1).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario2).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario3).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario4).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario5).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_red
            )
        )
        findViewById<TextView>(R.id.horario6).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario7).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario8).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario9).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
    }

    fun horario6(v: View) {
        horario = getString(R.string.horario6)
        findViewById<TextView>(R.id.horario1).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario2).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario3).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario4).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario5).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario6).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_red
            )
        )
        findViewById<TextView>(R.id.horario7).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario8).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario9).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
    }

    fun horario7(v: View) {
        horario = getString(R.string.horario7)
        findViewById<TextView>(R.id.horario1).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario2).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario3).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario4).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario5).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario6).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario7).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_red
            )
        )
        findViewById<TextView>(R.id.horario8).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario9).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
    }

    fun horario8(v: View) {
        horario = getString(R.string.horario8)
        findViewById<TextView>(R.id.horario1).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario2).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario3).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario4).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario5).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario6).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario7).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario8).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_red
            )
        )
        findViewById<TextView>(R.id.horario9).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
    }

    fun horario9(v: View) {
        horario = getString(R.string.horario9)
        findViewById<TextView>(R.id.horario1).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario2).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario3).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario4).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario5).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario6).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario7).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario8).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_green
            )
        )
        findViewById<TextView>(R.id.horario9).setTextColor(
            AppCompatResources.getColorStateList(
                baseContext,
                R.color.primary_red
            )
        )
    }

    fun pagar(view: View) {
        val idJogador = intent.getStringExtra("idJogador").toString()
        val nomeJogador = intent.getStringExtra("nomeJogador").toString()
        val nomeQuadra = intent.getStringExtra("nomeQuadra").toString()
        val nomeCentroEsportivo = intent.getStringExtra("nomeCentroEsportivo").toString()
        val modalidade = intent.getStringExtra("modalidade").toString()
        val preco = intent.getDoubleExtra("valor",0.0)
        val idQuadra = intent.getStringExtra("idQuadra").toString()
        val agendamento = Intent(baseContext, Agendamento::class.java)
        agendamento.putExtra("teste", calendario.date.toString())
        agendamento.putExtra("dia", dia)
        agendamento.putExtra("mes", mes)
        agendamento.putExtra("ano", ano)
        agendamento.putExtra("idQuadra", idQuadra)
        agendamento.putExtra("horario", horario)
        agendamento.putExtra("idJogador", idJogador)
        agendamento.putExtra("nomeJogador", nomeJogador)
        agendamento.putExtra("nomeQuadra", nomeQuadra)
        agendamento.putExtra("nomeCentroEsportivo", nomeCentroEsportivo)
        agendamento.putExtra("valor", preco)
        agendamento.putExtra("modalidade", modalidade)


        startActivity(agendamento)
    }
}