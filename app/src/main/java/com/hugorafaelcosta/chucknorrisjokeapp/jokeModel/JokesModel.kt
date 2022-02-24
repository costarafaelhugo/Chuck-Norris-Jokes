package com.hugorafaelcosta.chucknorrisjokeapp.jokeModel

import com.google.gson.annotations.SerializedName

data class JokesModel(
    @SerializedName("value")
    val joke: String
)