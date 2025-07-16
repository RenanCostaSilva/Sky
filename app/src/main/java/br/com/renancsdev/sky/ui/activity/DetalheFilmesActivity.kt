package br.com.renancsdev.sky.ui.activity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import br.com.renancsdev.sky.R
import br.com.renancsdev.sky.databinding.ActivityDetalheFilmesBinding
import br.com.renancsdev.sky.extension.esconder
import br.com.renancsdev.sky.extension.exibirImagemComPicasso2
import br.com.renancsdev.sky.extension.mostar
import br.com.renancsdev.sky.extension.pegarStringDoIntent
import br.com.renancsdev.sky.ui.activity.viewmodel.DetalheViewModel

class DetalheFilmes : AppCompatActivity() {

    private lateinit var  detalheFilmesBinding: ActivityDetalheFilmesBinding
    private lateinit var  detalheViewModel : DetalheViewModel

    private var context  = this@DetalheFilmes
    private var activity = context as Activity
    private var layout   = R.layout.activity_detalhe_filmes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inicializarLayout()
        inicializarViewModel()
        setarDadosViewModel()

    }
    //  Layout
    private fun inicializarLayout(){
        inicializarMainLayout()
        inicializarDataBindingMainActivityLayout()
    }
    private fun inicializarMainLayout(){
        setContentView(layout)
    }
    private fun inicializarDataBindingMainActivityLayout(){
        detalheFilmesBinding = DataBindingUtil.setContentView(activity , layout)
    }

    // ViewModel
    private fun configurarViewModel(){
        detalheViewModel = DetalheViewModel()
        detalheFilmesBinding.detalheViewModel = detalheViewModel
        detalheFilmesBinding.lifecycleOwner = activity as AppCompatActivity

    }
    private fun inicializarViewModel(){
        configurarViewModel()
        observadorNomeFilmes(detalheViewModel.nomeDoFilme)
        observadorDescricaoFilme(detalheViewModel.descricaoFilme)
        observadorFotoFilme(detalheViewModel.fotoFilme)
    }
    private fun observadorNomeFilmes(variavelDoViewModel: MutableLiveData<String>){
        val nameObserver = Observer<String> { novoNomeFilme ->
            detalheFilmesBinding.detalheVideoNome.text = "$novoNomeFilme\n"
        }
        variavelDoViewModel.observe(this, nameObserver)
    }
    private fun observadorDescricaoFilme(variavelDoViewModel: MutableLiveData<String>){
        val nameObserver = Observer<String> { novaDescricaoFilme ->
            detalheFilmesBinding.detalheVideoDescricao.text = "$novaDescricaoFilme\n"
        }
        variavelDoViewModel.observe(this, nameObserver)
    }
    private fun observadorFotoFilme(variavelDoViewModel: MutableLiveData<String>){
        val nameObserver = Observer<String> { novaFotoFilme ->
            detalheFilmesBinding.detalheVideoWallpapper.exibirImagemComPicasso2(novaFotoFilme)
            detalheFilmesBinding.detalheVideoThumb.exibirImagemComPicasso2(novaFotoFilme)
        }
        variavelDoViewModel.observe(this, nameObserver)
    }


    private fun setarDadosViewModel(){
        detalheViewModel.nomeDoFilme.value = activity.pegarStringDoIntent("filmeNome")
        detalheViewModel.descricaoFilme.value = activity.pegarStringDoIntent("filmeDescricao")
        detalheViewModel.fotoFilme.value = activity.pegarStringDoIntent("filmeFoto")
    }

}