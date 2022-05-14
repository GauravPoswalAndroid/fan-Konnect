package com.classplus.connect.login.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.classplus.connect.R
import com.classplus.connect.util.SharedPreferenceHelper

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            val token: String? = SharedPreferenceHelper.getToken(this)
            val landingUrl: String? = SharedPreferenceHelper.getLandingUrl(this)
            if (true == token?.isNotEmpty() && true == landingUrl?.isNotEmpty())
                WebViewActivity.startActivity(this, "$landingUrl$token")
            else
                LoginActivity.startActivity(this)
            finish()
        }, 3000)
    }
}