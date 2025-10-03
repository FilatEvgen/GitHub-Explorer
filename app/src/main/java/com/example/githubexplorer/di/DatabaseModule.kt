package com.example.githubexplorer.di

import android.content.Context
import androidx.room.Room
import com.example.githubexplorer.data.local.AppDatabase
import com.example.githubexplorer.data.local.RepoDao
import com.example.githubexplorer.data.local.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "github_database"
        )
            .build()
    }
    @Provides
    @Singleton
    fun provideUserDao(database: AppDatabase): UserDao = database.userDao()

    @Provides
    @Singleton
    fun provideRepoDao(database: AppDatabase): RepoDao = database.repoDao()
}