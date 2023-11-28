package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun AppNavigator() {
    // Use a state to track the current screen
    var currentScreen by remember { mutableStateOf<Screen>(Screen.MainScreen) }
    Box(modifier = Modifier.background(Color(0xFF1A1A1A))) {

        // Display the appropriate screen based on the current screen state
        when (currentScreen) {
            Screen.MainScreen -> MainScreen(onClick = { currentScreen = Screen.DNSGameScreen })
            Screen.DNSGameScreen -> QuestsGameScreen(onClick = {currentScreen = it})
        }
    }
}

// Define a sealed class to represent different screens
sealed class Screen {
    object MainScreen : Screen()
    object DNSGameScreen : Screen()
}

