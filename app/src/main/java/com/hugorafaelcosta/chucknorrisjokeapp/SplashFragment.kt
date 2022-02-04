package com.hugorafaelcosta.chucknorrisjokeapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler


class Splashscreen : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_splash)

        //Splash Screen duration
        val secondsDelayed = 1
        Handler().postDelayed({
            startActivity(Intent(this@Splashscreen, MainActivity::class.java))
            finish()
        }, (secondsDelayed * 3000).toLong())
    }
}
