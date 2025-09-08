package com.example.githubexplorer.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: Long,
    val login: String,
    val avatar_url: String,
    val name: String?,
    val followers: Int,
    val following: Int,
    val public_repos: Int,
)