package com.app.smartwater.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.smartwater.network.NetworkModule
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
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

    fun loginUser(email: String, password: String, onSuccess: (String) -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val response = NetworkModule.apiService.loginUser(email, password)
                onSuccess(response.token) // Assuming the response contains a token
            } catch (e: Exception) {
                onError(e.message ?: "Unknown error")
            }
        }
    }

    fun getAllUsers(onSuccess: (List<User>) -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val users = NetworkModule.apiService.getAllUsers()
                onSuccess(users)
            } catch (e: Exception) {
                onError(e.message ?: "Unknown error")
            }
        }
    }
}