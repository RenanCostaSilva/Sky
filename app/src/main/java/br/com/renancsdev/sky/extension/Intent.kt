package br.com.renancsdev.sky.extension

import android.content.Context
import android.content.Intent
import br.com.renancsdev.sky.model.Filmes

fun Intent.redirecionar(context: Context){
    context.startActivity(this)
}

fun Intent.adicionarDadosNoIntent(filmes: Filmes): Intent {

    this.putExtra("filmeNome"      , filmes.title)
    this.putExtra("filmeFoto"      , filmes.poster_path)
    this.putExtra("filmeDescricao" , filmes.overview)

    return this
}
