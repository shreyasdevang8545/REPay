package com.example.repay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashREPay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_repay)

        Handler().postDelayed({
            startActivity(Intent(this,MainFragment::class.java))
            finish()
        }, 2000)
    }
}