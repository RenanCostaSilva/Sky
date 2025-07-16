package br.com.renancsdev.sky.presentation.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import br.com.renancsdev.sky.presentation.ui.adapter.RecyclerFilmeAdapter
import br.com.renancsdev.sky.databinding.ActivityMainBinding
import br.com.renancsdev.sky.presentation.viewmodel.FilmeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var filmeAdapter: RecyclerFilmeAdapter
    private val viewModel: FilmeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupRecyclerView()
        setupObservers()
        fetchFilmes()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupRecyclerView() {
        filmeAdapter = RecyclerFilmeAdapter(emptyList())
        binding.rvSkyFilmes.apply {
            adapter = filmeAdapter
            layoutManager = GridLayoutManager(context, 2)
        }
    }

    private fun setupObservers() {
        viewModel.filmes.observe(this) { lista ->
            filmeAdapter.updateList(lista)
        }
        viewModel.loading.observe(this) { loading ->
            val visibility = if (loading) View.VISIBLE else View.GONE
            binding.pbSkyFilmesLoading.visibility = visibility
            binding.textView3.visibility = visibility
        }
        viewModel.mensagemErro.observe(this) { msg ->
            msg?.let { Toast.makeText(this, it, Toast.LENGTH_SHORT).show() }
        }
    }

    private fun fetchFilmes() {
        viewModel.buscarFilmes()
    }
}
