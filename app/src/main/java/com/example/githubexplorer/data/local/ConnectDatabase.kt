package com.example.githubexplorer.data.local

import android.content.Context
import androidx.room.Room

object Dependencies {
    private lateinit var applicationContext: Context
    fun init(context: Context) {
        applicationContext = context
    }
    private val appDatabase: AppDatabase by lazy {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "github_explorer_db")
            .build()
    }
}