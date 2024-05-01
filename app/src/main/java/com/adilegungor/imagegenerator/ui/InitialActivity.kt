package com.adilegungor.imagegenerator.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.imagegenerator.R

class InitialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initial)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, GeneratorActivity::class.java))
            finish()
        }, 3000) // 3 segundos
    }

}

