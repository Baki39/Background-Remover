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
import com.ultraclaw.bgremover.ui.theme.Indigo500
import com.ultraclaw.bgremover.ui.theme.DarkBackground
import com.ultraclaw.bgremover.ui.theme.DarkSurface
import com.ultraclaw.bgremover.ui.theme.DarkSurfaceVariant

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun EditorScreen(
    imageUri: Uri,
    onEnhanceComplete: (Uri) -> Unit,
    onBack: () -> Unit
) {
    var isProcessing by remember { mutableStateOf(false) }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Simple Top Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(DarkSurface)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Edit Image",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White
                )
            }

            // Image Preview
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(DarkSurfaceVariant),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = rememberAsyncImagePainter(imageUri),
                    contentDescription = "Selected Image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
            }

            // Bottom Controls
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Enhancement Options",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Simple option chips
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    SimpleChip("✨ Quality Boost", selected = true, onClick = {})
                    SimpleChip("🔍 Remove Blur", selected = true, onClick = {})
                    SimpleChip("📈 Upscale", selected = true, onClick = {})
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Enhance Button
                Button(
                    onClick = { 
                        isProcessing = true 
                        // Simulate processing
                        android.os.Handler(android.os.Looper.getMainLooper()).postDelayed({
                            isProcessing = false
                            onEnhanceComplete(imageUri)
                        }, 2000)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Indigo500),
                    enabled = !isProcessing
                ) {
                    Text(
                        text = if (isProcessing) "Processing..." else "Enhance Image",
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}

@Composable
private fun SimpleChip(text: String, selected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(if (selected) Indigo500.copy(alpha = 0.2f) else DarkSurfaceVariant)
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Text(text = text, color = Color.White)
    }
}