package com.example.desafiodimensa.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.desafiodimensa.MainActivity
import com.example.desafiodimensa.R

class SplashActivity : AppCompatActivity() {
    private val SPLASH_DISPLAY_LENGTH =
        1500 // Duração da splash screen em milissegundos (3 segundos)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Log.d("SplashActivity", "Inicializando componentes")

        Handler().postDelayed({
            val mainIntent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }
}