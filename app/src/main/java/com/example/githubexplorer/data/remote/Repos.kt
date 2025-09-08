package com.example.githubexplorer.data.remote

data class Repos(
    val name: String,
    val description: String,
    val stargazers_count: Int,
    val language: String
)
