package com.app.smartwater.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WaterLevelSection(waterLevel: Double?) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Water Level", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            waterLevel?.let {
                Text("Current Level: $it")
                if (it > 50.0) {
                    AlertDialog(
                        onDismissRequest = {},
                        title = { Text("Alert") },
                        text = { Text("Water level is too high!") },
                        confirmButton = {
                            Button(onClick = { /* Dismiss alert */ }) {
                                Text("OK")
                            }
                        }
                    )
                }
            } ?: Text("Loading...")
        }
    }
}