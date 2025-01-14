package com.app.smartwater.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.smartwater.viewmodel.DashboardViewModel
import com.app.smartwater.viewmodel.DashboardViewModelFactory
import com.app.smartwater.network.Alert

@Composable
fun DashboardScreen(authToken: String) {
    val viewModel: DashboardViewModel = viewModel(factory = DashboardViewModelFactory(authToken))
    var waterLevel by remember { mutableStateOf<Double?>(null) }
    var temperature by remember { mutableStateOf<Double?>(null) }
    var humidity by remember { mutableStateOf<Double?>(null) }
    var isLeakageDetected by remember { mutableStateOf<Boolean?>(null) }
    var alerts by remember { mutableStateOf<List<Alert>?>(null) }

    LaunchedEffect(Unit) {
        viewModel.getCurrentWaterLevel({ waterLevel = it }, { /* handle error */ })
        viewModel.getCurrentTemperature({ temperature = it }, { /* handle error */ })
        viewModel.getCurrentHumidity({ humidity = it }, { /* handle error */ })
        viewModel.checkLeakage({ isLeakageDetected = it }, { /* handle error */ })
        viewModel.getActiveAlerts({ alerts = it }, { /* handle error */ })
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Smart Water Management System Dashboard",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        WaterLevelSection(waterLevel)
        Spacer(modifier = Modifier.height(16.dp))
        TemperatureSection(temperature)
        Spacer(modifier = Modifier.height(16.dp))
        HumiditySection(humidity, isLeakageDetected)
        Spacer(modifier = Modifier.height(16.dp))
        AlertsSection(alerts)
    }
}