package com.ultraclaw.imageenhancer.ui.screens

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

sealed class Screen {
    object Home : Screen()
    object Editor : Screen()
    object Result : Screen()
}

@Composable
fun MainScreen() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Home) }
    var originalImageUri by remember { mutableStateOf<Uri?>(null) }
    var enhancedImageUri by remember { mutableStateOf<Uri?>(null) }

    when (val screen = currentScreen) {
        is Screen.Home -> {
            HomeScreen(
                onImageSelected = { uri ->
                    originalImageUri = uri
                    currentScreen = Screen.Editor
                }
            )
        }
        is Screen.Editor -> {
            if (originalImageUri != null) {
                EditorScreen(
                    imageUri = originalImageUri!!,
                    onEnhanceComplete = { enhancedUri ->
                        enhancedImageUri = enhancedUri
                        currentScreen = Screen.Result
                    },
                    onBack = {
                        currentScreen = Screen.Home
                    }
                )
            }
        }
        is Screen.Result -> {
            if (originalImageUri != null && enhancedImageUri != null) {
                ResultScreen(
                    originalImageUri = originalImageUri!!,
                    enhancedImageUri = enhancedImageUri!!,
                    onTryAgain = {
                        currentScreen = Screen.Home
                    },
                    onShare = {
                        // Share functionality
                    }
                )
            }
        }
    }
}