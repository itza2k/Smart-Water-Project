package com.app.smartwater.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HumiditySection(humidity: Double?, isLeakageDetected: Boolean?) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Humidity", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            humidity?.let {
                Text("Current Humidity: $it%")
            } ?: Text("Loading...")

            isLeakageDetected?.let {
                if (it) {
                    AlertDialog(
                        onDismissRequest = {},
                        title = { Text("Alert") },
                        text = { Text("Leakage detected!") },
                        confirmButton = {
                            Button(onClick = { /* Dismiss alert */ }) {
                                Text("OK")
                            }
                        }
                    )
                }
            } ?: Text("Checking for leakage...")
        }
    }
}