package com.etwicaksono.infomovie2.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.etwicaksono.infomovie2.R
import com.etwicaksono.infomovie2.ui.HomeActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashScreenActivity, HomeActivity::class.java))
            finish()
        }, 2000)
    }
}