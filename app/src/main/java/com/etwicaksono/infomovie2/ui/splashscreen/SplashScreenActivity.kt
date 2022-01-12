package com.etwicaksono.infomovie2.ui.splashscreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.etwicaksono.infomovie2.R
import com.etwicaksono.infomovie2.ui.HomeActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val viewModel: SplashScreenViewModel by viewModels()

        viewModel.isLoading.observe(this, { loading: Boolean ->
            if (!loading) {
                startActivity(Intent(this@SplashScreenActivity, HomeActivity::class.java))
                finish()
            }
        })

        viewModel.requestToken.observe(this,{ response ->
            val sharedPref = this.getSharedPreferences(
                    getString(R.string.preference_file_key),
                    Context.MODE_PRIVATE
                )
                val editor = sharedPref.edit()
                editor.putString(
                    getString(R.string.saved_request_token),response.requestToken                )
                editor.apply()
        })
    }
}