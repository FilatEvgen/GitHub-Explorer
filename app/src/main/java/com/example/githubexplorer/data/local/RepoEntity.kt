package com.example.githubexplorer.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repos")
data class RepoEntity(
    @PrimaryKey val id: Long,
    val userId: Long,
    val name: String,
    val description: String?,
    val stargazers_count: Int,
    val language: String?
)
