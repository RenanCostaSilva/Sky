package br.com.renancsdev.sky.presentation.di

import br.com.renancsdev.sky.data.api.FilmeService
import br.com.renancsdev.sky.data.repository.FilmeRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import br.com.renancsdev.sky.presentation.viewmodel.FilmeViewModel
import br.com.renancsdev.sky.presentation.viewmodel.FilmeDetalheViewModel

val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single { get<Retrofit>().create(FilmeService::class.java) }
    single { FilmeRepository(get(), getProperty("api_key")) }
    viewModel { FilmeViewModel(get())}
    viewModel { FilmeDetalheViewModel() }
}
