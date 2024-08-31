package br.com.renancsdev.sky.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FilmeDetalheViewModel: ViewModel()  {

    private val _nomeDoFilme = MutableLiveData<String>()
    val nomeDoFilme: LiveData<String> get() = _nomeDoFilme

    private val _descricaoFilme = MutableLiveData<String>()
    val descricaoFilme: LiveData<String> get() = _descricaoFilme

    private val _fotoFilme = MutableLiveData<String>()
    val fotoFilme: LiveData<String> get() = _fotoFilme

    // Métodos para setar valores (opcional)
    fun setNomeDoFilme(nome: String) { _nomeDoFilme.value = nome }
    fun setDescricaoFilme(desc: String) { _descricaoFilme.value = desc }
    fun setFotoFilme(url: String) { _fotoFilme.value = url }

}