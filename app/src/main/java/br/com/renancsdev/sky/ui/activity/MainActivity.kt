package br.com.renancsdev.sky.ui.activity

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import br.com.renancsdev.sky.R
import br.com.renancsdev.sky.databinding.ActivityMainBinding
import br.com.renancsdev.sky.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel : MainViewModel
    private var context:  Context    = this@MainActivity
    private var activity: Activity  = context as Activity
    private var layout = R.layout.activity_main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inicializarLayout()
        configurarViewModel()
        configurarObserrvers()
    }

    private fun configurarObserrvers() {
        mainViewModel.isError.value = false
    }

    override fun onResume() {
        super.onResume()
        popularListaDeFilmes()
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
        mainBinding = DataBindingUtil.setContentView(activity , R.layout.activity_main)
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

    // ViewModel
    private fun configurarViewModel(){
        mainViewModel = MainViewModel()
        mainBinding.mainViewModel = mainViewModel
        mainBinding.lifecycleOwner = this@MainActivity
    }

    private fun popularListaDeFilmes(){
        mainViewModel.chamarApi(context , mainBinding)
    }
}