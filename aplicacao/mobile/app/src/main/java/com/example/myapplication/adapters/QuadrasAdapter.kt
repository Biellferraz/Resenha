package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.models.QuadraMock

class QuadraAdapter (
    val quadraMock: List<QuadraMock>,
    val onClick: (QuadraMock) -> Unit
) : RecyclerView.Adapter<QuadraAdapter.FilmesViewHolder>() {

    override fun getItemCount() = quadraMock.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmesViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.quadra_item_list, parent, false)
        return FilmesViewHolder(view)
    }

    class FilmesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvmodalide: ImageView = view.findViewById(R.id.)
        var tvnumero_quadra: ImageView = view.findViewById(R.id.tvFilmeImage)
        var tvdisponivel: TextView = view.findViewById(R.id.tvFilmeTitle)
        val tvfkCentroEsportivo: TextView = view.findViewById(R.id.tvFilmeDescription)
    }

    override fun onBindViewHolder(holder: FilmesViewHolder, position: Int) {
        val filme = quadraMock[position]
        val filmeImage = quadraMock[position].imageUrl
        holder.tvFilmeTitle.text = filme.title
        holder.tvFilmeDescription.text = filme.decription

        Glide.with(holder.itemView).load(filmeImage).into(holder.tvFilmeImage)
        /*
        * Aqui modificaremos as propriedades do nosso FilmesViewHolder
        * */
        holder.itemView.setOnClickListener {
            onClick(filme)
        }
    }
}