package com.ultraclaw.bgremover.ui.screens

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import androidx.compose.material3.ExperimentalMaterial3Api
import com.ultraclaw.bgremover.ui.theme.Green400
import com.ultraclaw.bgremover.ui.theme.Indigo500
import com.ultraclaw.bgremover.ui.theme.DarkBackground
import com.ultraclaw.bgremover.ui.theme.DarkSurface
import com.ultraclaw.bgremover.ui.theme.DarkSurfaceVariant

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ResultScreen(
    originalImageUri: Uri,
    enhancedImageUri: Uri,
    onTryAgain: () -> Unit,
    onShare: () -> Unit
) {
    var showOriginal by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Success Badge
        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(40.dp))
                .background(Green400.copy(alpha = 0.2f)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "✅", style = MaterialTheme.typography.displaySmall)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Image Enhanced!",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Image Display
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clip(RoundedCornerShape(16.dp))
                .background(DarkSurfaceVariant),
            contentAlignment = Alignment.Center
        ) {
            val displayUri = if (showOriginal) originalImageUri else enhancedImageUri
            Image(
                painter = rememberAsyncImagePainter(displayUri),
                contentDescription = if (showOriginal) "Original" else "Enhanced",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Toggle buttons
        Row {
            FilterChip(
                selected = !showOriginal,
                onClick = { showOriginal = false },
                label = { Text("Enhanced") },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Indigo500,
                    selectedLabelColor = Color.White
                )
            )
            Spacer(modifier = Modifier.width(12.dp))
            FilterChip(
                selected = showOriginal,
                onClick = { showOriginal = true },
                label = { Text("Before") },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Indigo500,
                    selectedLabelColor = Color.White
                )
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Action Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(
                onClick = onShare,
                modifier = Modifier.weight(1f).height(48.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = DarkSurfaceVariant)
            ) {
                Text("Share")
            }
            
            Button(
                onClick = { /* Save */ },
                modifier = Modifier.weight(1f).height(48.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = DarkSurfaceVariant)
            ) {
                Text("Save")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Try Again Button
        Button(
            onClick = onTryAgain,
            modifier = Modifier.fillMaxWidth().height(56.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Indigo500)
        ) {
            Text("Enhance Another Image", style = MaterialTheme.typography.titleMedium)
        }
    }
}