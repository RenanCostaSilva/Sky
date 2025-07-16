package br.com.renancsdev.sky.ui.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import br.com.renancsdev.sky.R
import br.com.renancsdev.sky.databinding.ActivityApresentacaoBinding
import br.com.renancsdev.sky.ui.imagem.Animacao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.util.*
import kotlin.concurrent.timerTask


class Apresentacao : AppCompatActivity() {

    private lateinit var apresentacaoBinding: ActivityApresentacaoBinding
    private var context: Context = this@Apresentacao
    private var activity: Activity  = context as Activity
    private val layout = R.layout.activity_apresentacao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inicializarLayout()
        inicializaAnimacao()

    }

    //  Layout
    private fun inicializarLayout(){
        inicializarMainLayout()
        inicializarDataBindingMainActivityLayout()
    }
    private fun inicializarMainLayout(){
        setContentView(layout)
    }
    private fun inicializarDataBindingMainActivityLayout(){
        apresentacaoBinding = DataBindingUtil.setContentView(activity , layout)
    }

    // Animação
    private fun inicializaAnimacao(){
        animacaoRedirecionar(apresentacaoBinding.clSkyApresentacao , context)
    }
    private fun animacaoRedirecionar(constraint: ConstraintLayout, context: Context){
        Animacao().slideCimaBaixo(constraint , 2000)
        delayNaApresentacao(context)
    }
    private fun delayNaApresentacao(context: Context){
        Timer().schedule(timerTask {
            startActivity(Intent(context , MainActivity::class.java))
        }, 2500)
    }
}