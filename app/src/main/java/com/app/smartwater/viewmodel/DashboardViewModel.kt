package com.app.smartwater.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.smartwater.network.NetworkModule
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {
    fun getCurrentWaterLevel(onSuccess: (Double) -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val response = NetworkModule.apiService.getCurrentWaterLevel()
                onSuccess(response.level)
            } catch (e: Exception) {
                onError(e.message ?: "Unknown error")
            }
        }
    }

    fun getCurrentTemperature(onSuccess: (Double) -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val response = NetworkModule.apiService.getCurrentTemperature()
                onSuccess(response.temperature)
            } catch (e: Exception) {
                onError(e.message ?: "Unknown error")
            }
        }
    }

    fun getCurrentHumidity(onSuccess: (Double) -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val response = NetworkModule.apiService.getCurrentHumidity()
                onSuccess(response.humidity)
            } catch (e: Exception) {
                onError(e.message ?: "Unknown error")
            }
        }
    }

    fun checkLeakage(onSuccess: (Boolean) -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val response = NetworkModule.apiService.checkLeakage()
                onSuccess(response.isLeakage)
            } catch (e: Exception) {
                onError(e.message ?: "Unknown error")
            }
        }
    }

    fun getCurrentSensorData(onSuccess: (SensorDataResponse) -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val response = NetworkModule.apiService.getCurrentSensorData()
                onSuccess(response)
            } catch (e: Exception) {
                onError(e.message ?: "Unknown error")
            }
        }
    }

    fun getActiveAlerts(onSuccess: (List<Alert>) -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val alerts = NetworkModule.apiService.getActiveAlerts()
                onSuccess(alerts)
            } catch (e: Exception) {
                onError(e.message ?: "Unknown error")
            }
        }
    }
}