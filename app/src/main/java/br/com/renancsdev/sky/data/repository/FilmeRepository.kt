package br.com.renancsdev.sky.data.repository

import br.com.renancsdev.sky.data.api.FilmeService
import br.com.renancsdev.sky.model.Filmes

class FilmeRepository(
    private val api: FilmeService,
    private val apiKey: String
) {
    suspend fun getFilmesPopulares(): List<Filmes> {
        return api.pegarFilmesMaisPopulares(apiKey).results
    }
}