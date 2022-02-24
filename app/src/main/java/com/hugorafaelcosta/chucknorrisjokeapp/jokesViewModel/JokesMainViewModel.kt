package com.hugorafaelcosta.chucknorrisjokeapp.jokesViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hugorafaelcosta.chucknorrisjokeapp.jokeModel.JokesModel
import com.hugorafaelcosta.chucknorrisjokeapp.jokesRepository.JokesMainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokesMainViewModel : ViewModel() {

    private val liveJoke = MutableLiveData<String>()
    val _liveJoke: LiveData<String> = liveJoke
    val repository = JokesMainRepository()
    val errorMessage = MutableLiveData<String>()

    fun getJokes() {

        val request = repository.getJoke()

        request.enqueue(object : Callback<JokesModel> {
            override fun onResponse(call: Call<JokesModel>?, request: Response<JokesModel>?) {
                if (request?.code() == 200) {
                    val dadosChuck = request.body()
                    liveJoke.postValue(dadosChuck?.joke)
                }
            }

            override fun onFailure(call: Call<JokesModel>?, t: Throwable?) {
                if (t != null) {
                    errorMessage.postValue(t.message)
                }
            }
        })
    }
}

