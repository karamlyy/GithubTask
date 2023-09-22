package com.example.githubtask.network

import com.example.githubtask.service.GithubApi
import com.example.githubtask.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val _githubApi: GithubApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubApi::class.java)
    }
    val githubApi: GithubApi get() = _githubApi
}
