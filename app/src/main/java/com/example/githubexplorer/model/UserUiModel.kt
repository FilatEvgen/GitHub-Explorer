package com.example.githubexplorer.model

data class UserUiModel(
    val id: Long,
    val login: String,
    val avatarUrl: String,
    val name: String?,
    val followers: Int,
    val following: Int,
    val publicRepos: Int
)

