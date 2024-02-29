package br.com.renancsdev.sky.extension

import android.app.Activity
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.squareup.picasso.Picasso

fun ImageView.exibirImagemComPicasso2(nomeFilmeCrip: String){
    Picasso.get().load("https://image.tmdb.org/t/p/original/${ nomeFilmeCrip }").into(this)
}

fun ImageView.exibirNoGlide(nomeFilmeCrip: String){
    Glide.with(context)
        .load("https://image.tmdb.org/t/p/w500${nomeFilmeCrip}")
        .apply(RequestOptions.bitmapTransform(RoundedCorners(10) ))
        .into(this)
}