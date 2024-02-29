package br.com.renancsdev.sky.adapter

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import br.com.renancsdev.sky.databinding.ItemListBinding
import br.com.renancsdev.sky.extension.adicionarDadosNoIntent
import br.com.renancsdev.sky.extension.exibirNoGlide
import br.com.renancsdev.sky.model.Filmes
import br.com.renancsdev.sky.ui.activity.DetalheFilmes


class RecyclerFilmeViewHolder(private var binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {

    var context: Context = binding.root.context

    fun bind(filmes: Filmes) {
        iniciarDados(filmes)
    }

    private fun iniciarDados(filmes: Filmes){
        binding.cvCardItemFilme.setOnClickListener {context.startActivity(Intent(context , DetalheFilmes::class.java).adicionarDadosNoIntent(filmes)) }
        binding.skyFilmeFoto.exibirNoGlide(filmes.poster_path)
        binding.skyFilmeNome.text = filmes.title
    }

}