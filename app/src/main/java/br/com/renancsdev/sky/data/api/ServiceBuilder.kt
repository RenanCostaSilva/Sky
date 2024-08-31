package br.com.renancsdev.sky.data.api

import br.com.renancsdev.sky.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceBuilder {
    private const val BASE_URL = "https://api.themoviedb.org/3/"

    private val client: OkHttpClient by lazy { // Usar lazy para inicialização tardia
        OkHttpClient.Builder().apply {
            connectTimeout(30, TimeUnit.SECONDS) // Exemplo de timeout de conexão
            readTimeout(30, TimeUnit.SECONDS)    // Exemplo de timeout de leitura
            writeTimeout(30, TimeUnit.SECONDS)   // Exemplo de timeout de escrita

            if (BuildConfig.DEBUG) { // Supondo que você tenha BuildConfig.DEBUG
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY // Loga headers e body
                addInterceptor(logging)
            }
        }.build()
    }

    private val retrofit: Retrofit by lazy { // Usar lazy para inicialização tardia
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}