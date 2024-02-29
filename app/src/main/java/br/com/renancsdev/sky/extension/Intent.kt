package br.com.renancsdev.sky.extension

import android.content.Context
import android.content.Intent
import androidx.cardview.widget.CardView
import br.com.renancsdev.sky.model.Filmes
import br.com.renancsdev.sky.ui.activity.DetalheFilmes

fun Intent.redirecionar(context: Context){
    context.startActivity(this)
}

fun Intent.adicionarDadosNoIntent(filmes: Filmes): Intent {

    this.putExtra("filmeNome"      , filmes.title)
    this.putExtra("filmeFoto"      , filmes.poster_path)
    this.putExtra("filmeDescricao" , filmes.overview)

    return this
}
