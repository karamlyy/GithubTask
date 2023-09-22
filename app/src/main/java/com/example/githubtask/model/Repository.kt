package com.example.githubtask.model

data class Repository(
    val id: Int,
    val name: String,
    val description: String,
    val language: String,
    val created_at: String,
    val forks: Int,
    val stargazers_count: Int,
    val owner: User,
)
