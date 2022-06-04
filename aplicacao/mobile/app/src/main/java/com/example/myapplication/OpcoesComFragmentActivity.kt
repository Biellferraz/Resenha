package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit

class OpcoesComFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            findViewById<LinearLayout>(R.id.modalidadeFutebol).setOnClickListener { chamarFragment(1) }
            findViewById<LinearLayout>(R.id.modalidadeBasquete).setOnClickListener { chamarFragment(2) }
            findViewById<LinearLayout>(R.id.modalidadeTenis).setOnClickListener { chamarFragment(3) }
            findViewById<LinearLayout>(R.id.modalidadeVolei).setOnClickListener { chamarFragment(4) }


            //   findViewById<Button>(R.id.btnAba2).setOnClickListener { chamarFragment(2) }
            //add<Fragment1>(R.id.containerFragment1)
        }
    }
    fun chamarFragment(fragment: Int){
        when (fragment) {
            1 -> supportFragmentManager.commit { setReorderingAllowed(true)
                add<OpcoesComFragment>(R.id.modalidadeFutebol)
                val tela: Intent = Intent(baseContext,TelaDeQuadras::class.java)
                tela.putExtra("modalidade",getString(R.string.futebol))
                startActivity(tela)
            }
            2 -> supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<OpcoesComFragment>(R.id.modalidadeBasquete)
                val tela: Intent = Intent(baseContext,QuadraBasquete::class.java)
                tela.putExtra("modalidade",getString(R.string.basquete))
                startActivity(tela)
            }
            3 -> supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<OpcoesComFragment>(R.id.modalidadeTenis)
                val tela: Intent = Intent(baseContext,TelaQuadrasTenis::class.java)
                tela.putExtra("modalidade",getString(R.string.tenis))
                startActivity(tela)
            }
            4 -> supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<OpcoesComFragment>(R.id.modalidadeVolei)
                val tela: Intent = Intent(baseContext,TelaQuadrasVolei::class.java)
                tela.putExtra("modalidade",getString(R.string.volei))
                startActivity(tela)
            }
        }
    }
}