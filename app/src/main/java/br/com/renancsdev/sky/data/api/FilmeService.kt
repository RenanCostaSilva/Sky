package br.com.renancsdev.sky.data.api

import br.com.renancsdev.sky.model.FilmeResponse
import retrofit2.http.GET
import retrofit2.http.Query

fun interface FilmeService {

    @GET("movie/popular")
    suspend fun pegarFilmesMaisPopulares(
        @Query("api_key") apiKey: String
    ): FilmeResponse

}