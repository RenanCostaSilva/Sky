package br.com.renancsdev.sky.presentation.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.renancsdev.sky.R
import br.com.renancsdev.sky.databinding.ActivityApresentacaoBinding
import br.com.renancsdev.sky.presentation.ui.imagem.Animacao

class ApresentacaoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityApresentacaoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        animacao()
        scheduleRedirectToMain()
    }

    private fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_apresentacao)
    }

    private fun scheduleRedirectToMain() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 2500)
    }

    private fun animacao(){
        // Começa invisível e deslocado para baixo
        binding.cardLogo.alpha = 0f
        binding.cardLogo.translationY = 100f

        // Anima para aparecer subindo
        binding.cardLogo.animate()
            .alpha(1f)
            .translationY(0f)
            .setDuration(1200)
            .setStartDelay(200)
            .start()
    }
}
