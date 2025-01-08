package com.app.smartwater.network

import retrofit2.http.*

interface ApiService {
    @POST("api/auth/register")
    suspend fun registerUser(
        @Query("name") name: String,
        @Query("email") email: String,
        @Query("password") password: String
    )

    @POST("api/auth/login")
    suspend fun loginUser(
        @Query("email") email: String,
        @Query("password") password: String
    ): LoginResponse

    @GET("api/auth/users")
    suspend fun getAllUsers(
        @Header("Authorization") authHeader: String
    ): List<User>

    @POST("api/waterlevel")
    suspend fun addWaterLevel(
        @Query("level") level: Double,
        @Header("Authorization") authHeader: String
    )

    @GET("api/waterlevel/current")
    suspend fun getCurrentWaterLevel(
        @Header("Authorization") authHeader: String
    ): WaterLevelResponse

    @GET("api/temperature/current")
    suspend fun getCurrentTemperature(
        @Header("Authorization") authHeader: String
    ): TemperatureResponse

    @GET("api/humidity/current")
    suspend fun getCurrentHumidity(
        @Header("Authorization") authHeader: String
    ): HumidityResponse

    @GET("api/humidity/leakage")
    suspend fun checkLeakage(
        @Header("Authorization") authHeader: String
    ): LeakageResponse

    @POST("api/sensor/data")
    suspend fun addSensorData(
        @Body sensorData: SensorData,
        @Header("Authorization") authHeader: String
    )

    @GET("api/sensor/current")
    suspend fun getCurrentSensorData(
        @Header("Authorization") authHeader: String
    ): SensorDataResponse

    @POST("api/alerts")
    suspend fun createAlert(
        @Body alert: Alert,
        @Header("Authorization") authHeader: String
    )

    @GET("api/alerts/active")
    suspend fun getActiveAlerts(
        @Header("Authorization") authHeader: String
    ): List<Alert>
}