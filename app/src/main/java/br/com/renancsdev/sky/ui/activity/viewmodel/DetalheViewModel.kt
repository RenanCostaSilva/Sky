package br.com.renancsdev.sky.ui.activity.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetalheViewModel: ViewModel()  {

    var nomeDoFilme     = MutableLiveData<String>()
    var descricaoFilme  = MutableLiveData<String>()
    var fotoFilme       = MutableLiveData<String>()

}