package br.com.renancsdev.sky.presentation.ui.extension

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import br.com.renancsdev.sky.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.squareup.picasso3.Picasso

fun ImageView.exibirImagemComPicasso2(nomeFilmeCrip: String){
    Picasso.Builder(context).build().load("https://image.tmdb.org/t/p/original/${ nomeFilmeCrip }").into(this)
}

fun ImageView.exibirNoGlide(nomeFilmeCrip: String){
    Glide.with(context)
        .load("https://image.tmdb.org/t/p/w500${nomeFilmeCrip}")
        .placeholder(android.R.drawable.ic_menu_gallery)
        .error(android.R.drawable.ic_menu_report_image)
        .apply(RequestOptions.bitmapTransform(RoundedCorners(10) ))
        .into(this)
}

@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(url: String?) {
    Glide.with(this.context)
        .load("https://image.tmdb.org/t/p/w500${url ?: ""}")
        .placeholder(android.R.drawable.ic_menu_gallery)
        .error(android.R.drawable.ic_menu_report_image)
        .placeholder(R.drawable.poderosochefao2) // Adapte conforme seu projeto
        .into(this)
}