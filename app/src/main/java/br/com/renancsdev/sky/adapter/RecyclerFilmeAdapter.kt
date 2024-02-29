package br.com.renancsdev.sky.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.renancsdev.sky.databinding.ItemListBinding
import br.com.renancsdev.sky.model.Filmes


class RecyclerFilmeAdapter (private var filmes: List<Filmes>): RecyclerView.Adapter<RecyclerFilmeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerFilmeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(layoutInflater)
        return RecyclerFilmeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerFilmeViewHolder, position: Int) {
        holder.bind(filmes[position])
    }

    override fun getItemCount() = filmes.size

}