package com.hugorafaelcosta.chucknorrisjokeapp

import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.hugorafaelcosta.chucknorrisjokeapp.databinding.FragmentJokesBinding
import com.hugorafaelcosta.chucknorrisjokeapp.databinding.FragmentSplashBinding
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: FragmentJokesBinding
    private lateinit var splashBinding: FragmentSplashBinding

    val URL = "https://api.icndb.com/jokes/random"
    var okHttpClient: OkHttpClient = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentJokesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.giveMeAJokeBtn.setOnClickListener {
            loadRandomJoke()
        }
        actionBar?.hide()
        supportActionBar?.hide();
    }

    private fun loadRandomJoke() {
        runOnUiThread{
            binding.progressBar.visibility = View.VISIBLE
        }
        val request: Request = Request.Builder().url(URL).build()
        okHttpClient.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: Call, e: IOException) {
            }

            override fun onResponse(call: Call, response: Response) {
                val json = response.body?.string()
                val txt = (JSONObject(json).getJSONObject("value")).get("joke").toString()

                runOnUiThread {
                    binding.progressBar.visibility = View.GONE
                    binding.jokeTextView.text = Html.fromHtml(txt)
                }

            }
        })
    }

}