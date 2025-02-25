package com.example.desafiodimensa.splash

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.desafiodimensa.ui.initial.InitialActivity
import com.example.desafiodimensa.R
import com.example.desafiodimensa.databinding.ActivitySplashBinding


class SplashActivity : AppCompatActivity() {

    companion object {
        private const val SPLASH_DISPLAY_LENGTH = 1500L
    }

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(R.string.splash_activity_log_tag.toString(), getString(R.string.splash_activity_log_message))

        binding.root.postDelayed({
            val mainIntent = Intent(this, InitialActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, SPLASH_DISPLAY_LENGTH)
    }
}