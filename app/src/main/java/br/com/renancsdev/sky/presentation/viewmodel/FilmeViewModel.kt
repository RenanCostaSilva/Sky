package br.com.renancsdev.sky.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.renancsdev.sky.data.repository.FilmeRepository
import br.com.renancsdev.sky.model.Filmes
import kotlinx.coroutines.launch

class FilmeViewModel(
    private val repository: FilmeRepository
) : ViewModel() {

    val filmes = MutableLiveData<List<Filmes>>()
    val loading = MutableLiveData<Boolean>()
    val isError = MutableLiveData<Boolean>()
    val mensagemErro = MutableLiveData<String?>()

    fun buscarFilmes() {
        loading.value = true
        viewModelScope.launch {
            try {
                val lista = repository.getFilmesPopulares()
                filmes.value = lista
                isError.value = lista.isEmpty()
                mensagemErro.value = if (lista.isEmpty()) "Nenhum filme encontrado." else null
            } catch (e: Exception) {
                isError.value = true
                mensagemErro.value = e.localizedMessage ?: "Falha ao carregar filmes."
            } finally {
                loading.value = false
            }
        }
    }
}
