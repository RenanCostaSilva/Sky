package br.com.renancsdev.sky.ui.activity.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.renancsdev.sky.api.Call
import br.com.renancsdev.sky.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {

    fun chamarApi(context: Context , binding: ActivityMainBinding){

        CoroutineScope(Dispatchers.IO).launch {
            Call(context , binding).verificarRetornoDaApi()
        }

    }

}