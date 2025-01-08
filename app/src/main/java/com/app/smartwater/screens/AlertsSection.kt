package com.app.smartwater.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.app.smartwater.models.Alert

@Composable
fun AlertsSection(alerts: List<Alert>?) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Active Alerts", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            alerts?.let {
                it.forEach { alert ->
                    Text("Type: ${alert.type}")
                    Text("Severity: ${alert.severity}")
                    Text("Message: ${alert.message}")
                    Spacer(modifier = Modifier.height(8.dp))
                }
            } ?: Text("Loading...")
        }
    }
}