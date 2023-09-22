package com.example.githubtask.service

import com.example.githubtask.model.Repository
import com.example.githubtask.model.ResponseDTO
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface GithubApi {

    //https://api.github.com/search/repositories?q=created%3A%3E2017-05-17&sort=stars&order=desc
    @GET("search/repositories")
    @Headers("Accept: application/json")
    suspend fun getRepo(
        @Query("q") query: String,
        @Query("sort") sort: String = "stars",
        @Query("order") order: String = "desc",

    ): ResponseDTO
}