package com.app.smartwater.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.app.smartwater.network.SensorDataResponse

@Composable
fun SensorDataSection(sensorData: SensorDataResponse?) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Sensor Data", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            sensorData?.let {
                Text("Temperature: ${it.temperature}°C")
                Text("Humidity: ${it.humidity}%")
                Text("Water Level: ${it.waterLevel}")
            } ?: Text("Loading...")
        }
    }
}