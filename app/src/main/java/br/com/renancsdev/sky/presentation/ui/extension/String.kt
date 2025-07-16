package br.com.renancsdev.sky.presentation.ui.extension

import android.app.Activity

fun  String.pegarStringDoIntent(activity: Activity, tagDoIntent: String): String{
     return activity.intent.getStringExtra(tagDoIntent).toString()
}