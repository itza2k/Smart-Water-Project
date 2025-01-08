package com.app.smartwater.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.smartwater.network.NetworkModule
import kotlinx.coroutines.launch
import com.app.smartwater.network.User

class AuthViewModel : ViewModel() {
    var authToken: String? = null
        private set

    fun registerUser(name: String, email: String, password: String, onSuccess: () -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                NetworkModule.apiService.registerUser(name, email, password)
                onSuccess()
            } catch (e: Exception) {
                onError(e.message ?: "Unknown error")
            }
        }
    }

    fun loginUser(email: String, password: String, onSuccess: () -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val response = NetworkModule.apiService.loginUser(email, password)
                authToken = "Bearer ${response.token}"
                onSuccess()
            } catch (e: Exception) {
                onError(e.message ?: "Unknown error")
            }
        }
    }

    fun getAllUsers(onSuccess: (List<User>) -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val token = authToken ?: throw IllegalStateException("Auth token is null")
                val users = NetworkModule.apiService.getAllUsers(token)
                onSuccess(users)
            } catch (e: Exception) {
                onError(e.message ?: "Unknown error")
            }
        }
    }
}