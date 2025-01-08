package com.app.smartwater.network

data class User(val id: String, val name: String, val email: String)
data class WaterLevelResponse(val level: Double)
data class TemperatureResponse(val temperature: Double)
data class HumidityResponse(val humidity: Double)
data class LeakageResponse(val isLeakage: Boolean)
data class SensorData(val temperature: Double, val humidity: Double, val waterLevel: Double)
data class SensorDataResponse(val temperature: Double, val humidity: Double, val waterLevel: Double)
data class Alert(val type: String, val severity: String, val message: String)