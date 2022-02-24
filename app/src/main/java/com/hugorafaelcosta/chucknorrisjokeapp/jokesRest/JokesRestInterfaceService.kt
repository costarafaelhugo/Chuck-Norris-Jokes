package com.hugorafaelcosta.chucknorrisjokeapp.jokesRest

import com.hugorafaelcosta.chucknorrisjokeapp.jokeModel.JokesModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface JokesRestInterfaceService {
    @GET("/jokes/random")
    fun getJoke(): Call<JokesModel>

    companion object {
        private val retrofitService: JokesRestInterfaceService by lazy {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.chucknorris.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(JokesRestInterfaceService::class.java)
        }

        fun getInstance(): JokesRestInterfaceService {
            return retrofitService
        }
    }
}