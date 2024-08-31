package br.com.renancsdev.sky.presentation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.renancsdev.sky.R
import br.com.renancsdev.sky.databinding.ActivityDetalheFilmesBinding
import br.com.renancsdev.sky.presentation.viewmodel.FilmeDetalheViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetalheFilmesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalheFilmesBinding
    private val detalheViewModel: FilmeDetalheViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupViewModel()
        setIntentExtras()
    }

    private fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detalhe_filmes)
        binding.lifecycleOwner = this
    }

    private fun setupViewModel() {
        binding.detalheViewModel = detalheViewModel
    }

    private fun setIntentExtras() {
        detalheViewModel.setNomeDoFilme(intent.getStringExtra("filmeNome") ?: "")
        detalheViewModel.setDescricaoFilme(intent.getStringExtra("filmeDescricao") ?: "")
        detalheViewModel.setFotoFilme(intent.getStringExtra("filmeFoto") ?: "")
    }
}
