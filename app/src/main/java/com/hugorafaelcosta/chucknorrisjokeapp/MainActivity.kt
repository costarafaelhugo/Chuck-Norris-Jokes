package com.hugorafaelcosta.chucknorrisjokeapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.hugorafaelcosta.chucknorrisjokeapp.databinding.ActivityChuckNorrisJokesBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChuckNorrisJokesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChuckNorrisJokesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startSplashFragment()


    }

    private fun startSplashFragment() {
        val splashFragment = Splashscreen()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, splashFragment)
            .commit()

        Handler(Looper.getMainLooper()).postDelayed({
            startChuckNorrisJokesFragment()
        }, 3000)
    }

    private fun startChuckNorrisJokesFragment() {
        val norrisjokeFragment = JokesFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, norrisjokeFragment)
            .commit()
    }

}