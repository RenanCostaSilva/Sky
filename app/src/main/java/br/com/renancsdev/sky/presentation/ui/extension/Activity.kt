package br.com.renancsdev.sky.presentation.ui.extension

import android.app.Activity

fun Activity.pegarStringDoIntent(tagDoIntent: String): String {
    return this.intent.getStringExtra(tagDoIntent) ?: ""
}