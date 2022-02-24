package com.hugorafaelcosta.chucknorrisjokeapp.jokesRepository

import com.hugorafaelcosta.chucknorrisjokeapp.jokesRest.JokesRestInterfaceService

class JokesMainRepository {
    fun getJoke() = JokesRestInterfaceService.getInstance().getJoke()
}