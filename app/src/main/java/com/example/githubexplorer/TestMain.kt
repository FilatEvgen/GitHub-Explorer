package com.example.githubexplorer

import kotlinx.coroutines.runBlocking
fun main() = runBlocking {
    val service = GitHubApiService.create()
    try {
        // Проверяем получение списка пользователей
        val users = service.getUsers(since = 0, perPage = 5)
        println("Получено пользователей: ${users.size}")
        users.forEach { println(it.login) }
        // Проверяем поиск пользователей
        val searchResult = service.searchUsers(query = "john", page = 1, perPage = 5)
        println("Найдено пользователей: ${searchResult.total_count}")
        searchResult.items.forEach { println(it.login) }
        // Проверяем детали пользователя (берём первого из списка)
        val username = users.firstOrNull()?.login ?: "octocat"
        val userDetails = service.getUser (username)
        println("Детали пользователя $username: имя = ${userDetails.name}, подписчиков = ${userDetails.followers}")
        // Проверяем репозитории пользователя
        val repos = service.getUserRepos(username)
        println("Репозитории пользователя $username:")
        repos.forEach { println("${it.name} - ⭐ ${it.stargazers_count}") }
    } catch (e: Exception) {
        println("Ошибка при запросе: ${e.message}")
    }
}