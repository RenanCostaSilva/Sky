package br.com.renancsdev.sky.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.renancsdev.sky.R
import br.com.renancsdev.sky.api.Call
import br.com.renancsdev.sky.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {

    var isError = MutableLiveData<Boolean>()

    fun chamarApi(context: Context , binding: ActivityMainBinding){

        if(context.resources.getString(R.string.api_key) == "" ||
            context.resources.getString(R.string.api_key).length != 32 ||
              context.resources.getString(R.string.api_key) == "informe_a_sua_api_key_aqui"){
            isError.value = true
        }else{
            isError.value = false
            CoroutineScope(IO).launch {
                Call(context , binding).verificarRetornoDaApi()
            }
        }

    }

}