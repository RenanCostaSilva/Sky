package br.com.renancsdev.sky.extension

import android.app.Activity

fun Activity.pegarStringDoIntent(tagDoIntent: String): String {
    return this.intent.getStringExtra(tagDoIntent).toString()
}