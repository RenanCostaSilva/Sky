package br.com.renancsdev.sky.presentation.ui.adapter

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import br.com.renancsdev.sky.databinding.ItemListBinding
import br.com.renancsdev.sky.presentation.ui.extension.adicionarDadosNoIntent
import br.com.renancsdev.sky.presentation.ui.extension.exibirNoGlide
import br.com.renancsdev.sky.model.Filmes
import br.com.renancsdev.sky.presentation.ui.activity.DetalheFilmesActivity


class RecyclerFilmeViewHolder(private var binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(filme: Filmes) = with(binding) {
        cvCardItemFilme.setOnClickListener {
            binding.root.context.startActivity(Intent(root.context, DetalheFilmesActivity::class.java).adicionarDadosNoIntent(filme))
        }
        skyFilmeFoto.exibirNoGlide(filme.poster_path )
        skyFilmeNome.text = filme.title
    }

}