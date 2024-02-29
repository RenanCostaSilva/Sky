package br.com.renancsdev.sky.ui.activity

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import br.com.renancsdev.sky.R
import br.com.renancsdev.sky.databinding.ActivityMainBinding
import br.com.renancsdev.sky.ui.activity.viewmodel.MainViewModel

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

    // ViewModel
    private fun configurarViewModel(){
        mainViewModel = MainViewModel()
        mainBinding.mainViewModel = mainViewModel
        mainBinding.lifecycleOwner = activity as AppCompatActivity
    }

    private fun popularListaDeFilmes(){
        mainViewModel.chamarApi(context , mainBinding)
    }
}