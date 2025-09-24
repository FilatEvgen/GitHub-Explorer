package com.example.githubexplorer.ui.main

import UserRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubexplorer.model.UserUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _users = MutableStateFlow<List<UserUiModel>>(emptyList())
    val users: StateFlow<List<UserUiModel>> = _users

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        loadUsers()
    }

    fun loadUsers() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                val userEntities = userRepository.getUsers()
                val uiModels = userEntities.map {
                    UserUiModel(
                        id = it.id,
                        login = it.login,
                        avatarUrl = it.avatar_url,
                        name = it.name,
                        followers = it.followers,
                        following = it.following,
                        publicRepos = it.public_repos
                    )
                }
                _users.value = uiModels
            } catch (e: Exception) {
                _error.value = e.message ?: "Unknown error"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
