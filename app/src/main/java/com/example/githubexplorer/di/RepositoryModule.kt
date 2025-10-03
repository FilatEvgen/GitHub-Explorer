package com.example.githubexplorer.di

import com.example.githubexplorer.repository.UserRepository
import com.example.githubexplorer.data.local.RepoDao
import com.example.githubexplorer.data.local.UserDao
import com.example.githubexplorer.data.remote.GitHubApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideUserRepository(
        apiService: GitHubApiService,
        userDao: UserDao,
        repoDao: RepoDao
    ): UserRepository {
        return UserRepository(apiService,userDao,repoDao)
    }
}