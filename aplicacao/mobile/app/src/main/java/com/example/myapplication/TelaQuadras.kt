package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import com.example.myapplication.databinding.ActivityMainBinding
import java.sql.Date

class TelaQuadras : AppCompatActivity() {
    private lateinit var calendario: CalendarView
//    private lateinit var binding = ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_quadras)
        calendario = findViewById(R.id.calendar)
        calendario.setOnDateChangeListener(CalendarView.OnDateChangeListener { view, year, month, dayOfMonth ->
        val intent = Intent(this, Agendamento::class.java)
        intent.putExtra("dia",dayOfMonth)
        intent.putExtra("mes",month)
        intent.putExtra("ano",year)
    })
    }

    private var horario: String = ""

    fun horario1(v: View){
        horario = "@string/horario1"
        findViewById<TextView>(R.id.horario1).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_red))
        findViewById<TextView>(R.id.horario2).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario3).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario4).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario5).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario6).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario7).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario8).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario9).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))

        val agendamento: Intent = Intent(baseContext,Agendamento::class.java)

        agendamento.putExtra("horario",horario)
    }

    fun horario2(v: View){
        horario = "@string/horario2"
        findViewById<TextView>(R.id.horario1).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario2).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_red))
        findViewById<TextView>(R.id.horario3).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario4).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario5).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario6).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario7).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario8).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario9).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))

        val agendamento: Intent = Intent(baseContext,Agendamento::class.java)

        agendamento.putExtra("horario",horario)
    }

    fun horario3(v: View){
        horario = "@string/horario3"
        findViewById<TextView>(R.id.horario1).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario2).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario3).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_red))
        findViewById<TextView>(R.id.horario4).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario5).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario6).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario7).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario8).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario9).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))

        val agendamento: Intent = Intent(baseContext,Agendamento::class.java)

        agendamento.putExtra("horario",horario)
    }

    fun horario4(v: View){
        horario = "@string/horario4"
        findViewById<TextView>(R.id.horario1).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario2).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario3).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario4).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_red))
        findViewById<TextView>(R.id.horario5).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario6).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario7).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario8).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario9).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))

        val agendamento: Intent = Intent(baseContext,Agendamento::class.java)

        agendamento.putExtra("horario",horario)
    }

    fun horario5(v: View){
        horario = "@string/horario5"
        findViewById<TextView>(R.id.horario1).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario2).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario3).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario4).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario5).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_red))
        findViewById<TextView>(R.id.horario6).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario7).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario8).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario9).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))

        val agendamento: Intent = Intent(baseContext,Agendamento::class.java)

        agendamento.putExtra("horario",horario)
    }

    fun horario6(v: View){
        horario = "@string/horario6"
        findViewById<TextView>(R.id.horario1).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario2).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario3).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario4).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario5).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario6).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_red))
        findViewById<TextView>(R.id.horario7).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario8).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario9).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))

        val agendamento: Intent = Intent(baseContext,Agendamento::class.java)

        agendamento.putExtra("horario",horario)
    }

    fun horario7(v: View){
        horario = "@string/horario7"
        findViewById<TextView>(R.id.horario1).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario2).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario3).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario4).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario5).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario6).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario7).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_red))
        findViewById<TextView>(R.id.horario8).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario9).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))

        val agendamento: Intent = Intent(baseContext,Agendamento::class.java)

        agendamento.putExtra("horario",horario)
    }

    fun horario8(v: View){
        horario = "@string/horario8"
        findViewById<TextView>(R.id.horario1).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario2).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario3).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario4).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario5).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario6).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario7).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario8).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_red))
        findViewById<TextView>(R.id.horario9).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))

        val agendamento: Intent = Intent(baseContext,Agendamento::class.java)

        agendamento.putExtra("horario",horario)
    }

    fun horario9(v: View){
        horario = "@string/horario9"
        findViewById<TextView>(R.id.horario1).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario2).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario3).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario4).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario5).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario6).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario7).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario8).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_green))
        findViewById<TextView>(R.id.horario9).
        setTextColor(AppCompatResources.getColorStateList(baseContext,R.color.primary_red))

        val agendamento: Intent = Intent(baseContext,Agendamento::class.java)

        agendamento.putExtra("horario",horario)
    }

    fun pagar(view: View) {
        startActivity(Intent(baseContext, Agendamento::class.java))
    }
}