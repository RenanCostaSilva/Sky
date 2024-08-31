package br.com.renancsdev.sky.ui.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import br.com.renancsdev.sky.R
import br.com.renancsdev.sky.databinding.ActivityApresentacaoBinding
import br.com.renancsdev.sky.ui.imagem.Animacao
import java.util.*
import kotlin.concurrent.timerTask


class ApresentacaoActivity : AppCompatActivity() {

    private lateinit var apresentacaoBinding: ActivityApresentacaoBinding
    private var context: Context = this@ApresentacaoActivity
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

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        // Check the new orientation and adjust your layout or UI elements accordingly
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Handle landscape orientation
            requestedOrientation = SCREEN_ORIENTATION_LANDSCAPE
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            // Handle portrait orientation
            requestedOrientation = SCREEN_ORIENTATION_PORTRAIT
        }
    }
}