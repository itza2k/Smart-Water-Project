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
    suspend fun getAllUsers(): List<User>

    @POST("api/waterlevel")
    suspend fun addWaterLevel(@Query("level") level: Double)

    @GET("api/waterlevel/current")
    suspend fun getCurrentWaterLevel(): WaterLevelResponse

    @GET("api/temperature/current")
    suspend fun getCurrentTemperature(): TemperatureResponse

    @GET("api/humidity/current")
    suspend fun getCurrentHumidity(): HumidityResponse

    @GET("api/humidity/leakage")
    suspend fun checkLeakage(): LeakageResponse

    @POST("api/sensor/data")
    suspend fun addSensorData(@Body sensorData: SensorData)

    @GET("api/sensor/current")
    suspend fun getCurrentSensorData(): SensorDataResponse

    @POST("api/alerts")
    suspend fun createAlert(@Body alert: Alert)

    @GET("api/alerts/active")
    suspend fun getActiveAlerts(): List<Alert>
}