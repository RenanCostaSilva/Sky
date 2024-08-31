package br.com.renancsdev.sky.presentation.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.renancsdev.sky.databinding.ItemListBinding
import br.com.renancsdev.sky.model.Filmes


class RecyclerFilmeAdapter (private var filmes: List<Filmes>): RecyclerView.Adapter<RecyclerFilmeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerFilmeViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecyclerFilmeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerFilmeViewHolder, position: Int) {
        Log.d("Adapter", "onBindViewHolder: ${filmes[position].title}")
        holder.bind(filmes[position])
    }

    override fun getItemCount() = filmes.size

    // Método eficiente para atualizar a lista sem recriar o adapter
    fun updateList(novaLista: List<Filmes>) {
        Log.d("Adapter", "Atualizando lista com ${novaLista.size} filmes")
        this.filmes = novaLista
        notifyDataSetChanged()
    }

}