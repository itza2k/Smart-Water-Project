package com.app.smartwater

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.app.smartwater.screens.DashboardScreen
import com.app.smartwater.screens.LoginScreen
import com.app.smartwater.screens.RegisterScreen
import com.app.smartwater.ui.screens.*
import com.app.smartwater.ui.theme.SmartWaterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartWaterTheme {
                var currentScreen by remember { mutableStateOf<Screen>(Screen.Login) }

                when (currentScreen) {
                    is Screen.Login -> LoginScreen(
                        onLoginSuccess = { currentScreen = Screen.Dashboard },
                        onRegisterClick = { currentScreen = Screen.Register }
                    )
                    is Screen.Register -> RegisterScreen(
                        onRegisterSuccess = { currentScreen = Screen.Login },
                        onBackToLogin = { currentScreen = Screen.Login }
                    )
                    is Screen.Dashboard -> DashboardScreen()
                }
            }
        }
    }
}

sealed class Screen {
    object Login : Screen()
    object Register : Screen()
    object Dashboard : Screen()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SmartWaterTheme {
        LoginScreen(onLoginSuccess = {}, onRegisterClick = {})
    }
}