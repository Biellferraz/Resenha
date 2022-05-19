package com.example.myapplication.adapters

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.models.Quadra

class QuadrasAdapter(val quadras: List<Quadra>) :
    RecyclerView.Adapter<QuadrasAdapter.QuadraViewHolder>() {

    inner class QuadraViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(quadra: Quadra) {
            with(quadra) {
                itemView.findViewById<TextView>(R.id.text_centro_esportivo).text = centroEsportivo
                itemView.findViewById<TextView>(R.id.text_quadra).text = nome
                itemView.findViewById<TextView>(R.id.text_endereco).text = endereco
                itemView.findViewById<TextView>(R.id.text_preco).text = preco.toString()

                val imagemView = itemView.findViewById<ImageView>(R.id.img_quadra)
                Glide.with(itemView).load(imagem).into(imagemView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuadraViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.quadra_item_list, parent, false)
        return QuadraViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuadraViewHolder, position: Int) {
        holder.bind(quadras[position])
    }

    override fun getItemCount(): Int = quadras.size

}