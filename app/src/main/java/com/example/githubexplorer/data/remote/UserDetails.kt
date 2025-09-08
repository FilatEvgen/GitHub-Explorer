package com.example.githubexplorer.data.remote

data class UserDetails(
    val login: String,
    val id: Long,
    val avatar_url: String,
    val name: String,
    val followers: Int,
    val following: Int,
    val public_repos: Int,
)


