package com.example.githubexplorer.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RepoDao {

    @Query("SELECT * FROM repos WHERE userId = :userId ORDER BY stargazers_count DESC")
    suspend fun getReposForUser(userId: Long): List<RepoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRepos(repos: List<RepoEntity>)

    @Query("DELETE FROM repos WHERE userId = :userId")
    suspend fun clearReposForUser(userId: Long)
}