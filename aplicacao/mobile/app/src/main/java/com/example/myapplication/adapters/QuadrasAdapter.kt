package com.example.myapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.models.CentroEsportivo
import com.example.myapplication.models.Quadra

class QuadraAdapter (
    val quadraMock: List<Quadra>
) : RecyclerView.Adapter<QuadraAdapter.QuadraViewHolder>() {

    override fun getItemCount() = quadraMock.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuadraViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.quadra_item_list, parent, false)
        return QuadraViewHolder(view)
    }

    class QuadraViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvImage: ImageView = view.findViewById(R.id.img_quadra)
        var tvnumero_quadra: TextView = view.findViewById(R.id.text_quadra)
        var tvnome_centro_esportivo: TextView = view.findViewById(R.id.text_centro_esportivo)
        val tvlocalizacao: TextView = view.findViewById(R.id.text_endereco)
        val tvValor:TextView = view.findViewById(R.id.text_preco)
    }

    override fun onBindViewHolder(holder: QuadraViewHolder, position: Int) {
        val quadra = quadraMock[position]
        val quadraImage = quadraMock[position].imagem
        val centroEsportivo = quadraMock[position].centroEsportivo
        holder.tvnome_centro_esportivo.text = centroEsportivo.nome
        holder.tvnumero_quadra.text = quadra.nome
        holder.tvlocalizacao.text = centroEsportivo.cidade
        holder.tvValor.text = quadra.preco.toString()

        Glide.with(holder.itemView).load(quadraImage).into(holder.tvImage)
        /*
        * Aqui modificaremos as propriedades do nosso FilmesViewHolder
        * */
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Clicou na quadra", Toast.LENGTH_LONG).show()
        }
    }
}