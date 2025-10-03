package com.example.githubexplorer.repository

import com.example.githubexplorer.data.local.RepoDao
import com.example.githubexplorer.data.local.RepoEntity
import com.example.githubexplorer.data.local.UserDao
import com.example.githubexplorer.data.local.UserEntity
import com.example.githubexplorer.data.remote.GitHubApiService

class UserRepository (
    private val apiService: GitHubApiService,
    private val userDao: UserDao,
    private val repoDao: RepoDao
) {

    suspend fun getUsers(since: Long? = null, perPage: Int = 30): List<UserEntity> {
        val cachedUser = userDao.getAllUsers()
        if (cachedUser.isNotEmpty()) {
            refreshUsersFromNetwork(since, perPage)
            return cachedUser
        } else {
            return refreshUsersFromNetwork(since, perPage)
        }
    }
    private suspend fun refreshUsersFromNetwork(since: Long?, perPage: Int): List<UserEntity> {
        val networkUsers = apiService.getUsers(since, perPage)
        val entities = networkUsers.map {
            UserEntity (
                id = it.id,
                login = it.login,
                avatar_url = it.avatar_url,
                name = null,
                followers = 0,
                following = 0,
                public_repos = 0
            )
        }
        userDao.insertUsers(entities)
        return entities
    }
    suspend fun getUserDetails(username: String): UserEntity? {
        val cachedUser = userDao.getAllUsers().find { it.login == username }
        if (cachedUser != null) {
            refreshUsersDetailsFromNetwork(username)
            return cachedUser
        } else {
            return refreshUsersDetailsFromNetwork(username)
        }
    }
    private suspend fun refreshUsersDetailsFromNetwork(username: String): UserEntity? {
        val userDetails = apiService.getUser(username)
        val entity = UserEntity (
            id = userDetails.id,
            login = userDetails.login,
            avatar_url = userDetails.avatar_url,
            name = userDetails.name,
            followers = userDetails.followers,
            following = userDetails.following,
            public_repos = userDetails.public_repos
        )
        userDao.insertUsers(listOf(entity))
        return entity
    }
    suspend fun getUserRepos(userId: Long, username: String): List <RepoEntity> {
        val cachedRepos = repoDao.getReposForUser(userId)
        if (cachedRepos.isNotEmpty()) {
            refreshUserReposFromNetwork(userId, username)
            return cachedRepos
        } else {
            return refreshUserReposFromNetwork(userId,username)
        }
    }
    private suspend fun refreshUserReposFromNetwork(userId: Long, username: String): List<RepoEntity> {
        val repos = apiService.getUserRepos(username)
        val entities = repos.map {
            RepoEntity(
                id = it.id,
                userId = userId,
                name = it.name,
                description = it.description,
                stargazers_count = it.stargazers_count,
                language = it.language
            )
        }
        repoDao.insertRepos(entities)
        return entities
    }
}



