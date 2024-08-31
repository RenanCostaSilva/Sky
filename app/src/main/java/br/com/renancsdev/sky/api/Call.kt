package br.com.renancsdev.sky.api

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import br.com.renancsdev.sky.R
import br.com.renancsdev.sky.databinding.ActivityMainBinding
import br.com.renancsdev.sky.extension.esconder
import br.com.renancsdev.sky.extension.mostar
import br.com.renancsdev.sky.model.Filmes
import br.com.renancsdev.sky.model.Result
import br.com.renancsdev.sky.adapter.RecyclerFilmeAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Call(var context: Context, private var binding: ActivityMainBinding) {

    private val request = ServiceBuilder.buildService(EndPoints::class.java)

    //Api
    private fun chamadaDaApi(): Call<Result> = request.pegarFilmesMaisPopulares(context.resources.getString(R.string.api_key))

    fun verificarRetornoDaApi(){
        chamadaDaApi().enqueue(object : Callback<Result> {
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                mostraRespostaDaAPI(response)
            }
            override fun onFailure(call: Call<Result>, t: Throwable) {
                Log.e("Api", "Error: ${t.message}")
                Toast.makeText(context , "Failed to get response: ${t.message}" , Toast.LENGTH_SHORT).show()
                mostarLogRespostaAPI("ChamadaAPI" , "Erro, motivo: ${t.message}")
            }
        })
    }
    private fun mostraRespostaDaAPI(resposta: Response<Result>){
        if(buscarDaRespostaDaApi(resposta)){
            configurarAdapterDeRespostaAPI(resposta , binding)
        }else{
            Log.e("Api", " Erro: ${resposta.errorBody().toString()}")
            Toast.makeText(context , resposta.errorBody().toString(), Toast.LENGTH_SHORT).show()
        }
    }
    private fun buscarDaRespostaDaApi(resposta: Response<Result>): Boolean{
        return resposta.isSuccessful
    }
    private fun configurarAdapterDeRespostaAPI(resposta: Response<Result> , mainBinding: ActivityMainBinding ){
        binding.flSkyFilmesLoading.mostar()

        if (resposta.body() != null) initFilmesAdapter2(resposta.body()!!.results , mainBinding )
              else  mostarLogRespostaAPI("ChamadaAPI" , "Não foi Possível obter o corpo da resposta !")

        binding.flSkyFilmesLoading.esconder()
    }
    private fun initFilmesAdapter2(filmes: List<Filmes>, binding: ActivityMainBinding){
        binding.rvSkyFilmes.apply {
           layoutManager = GridLayoutManager(context , 2)
           adapter = RecyclerFilmeAdapter(filmes)
        }
    }

    //Log
    fun mostarLogRespostaAPI(tag: String , mensagem: String) {
        Log.e(tag, mensagem)
        Toast.makeText(context , mensagem , Toast.LENGTH_SHORT).show()
    }
}