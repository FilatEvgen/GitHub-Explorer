package com.example.githubexplorer.data.remote

data class ResultUsers(
    val total_count: Int,
    val incomplete_results: Boolean,
    val items: List<SearchUsers>
)

