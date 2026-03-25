package com.ultraclaw.bgremover.ui.screens

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.ultraclaw.bgremover.ui.theme.Indigo500
import com.ultraclaw.bgremover.ui.theme.Purple500
import com.ultraclaw.bgremover.ui.theme.DarkBackground
import com.ultraclaw.bgremover.ui.theme.DarkSurfaceVariant

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HomeScreen(onImageSelected: (Uri) -> Unit) {
    var selectedImage by remember { mutableStateOf<Uri?>(null) }
    
    // Simple gallery launcher using content resolver
    // For now we'll use a placeholder
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
            .padding(24.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // App Icon placeholder
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(Indigo500),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "🖼️", style = MaterialTheme.typography.displayLarge)
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "AI Image Enhancer",
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Enhance your photos with AI power",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White.copy(alpha = 0.7f),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(48.dp))

            // Select Image Button
            Button(
                onClick = { /* Will add image picker */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Indigo500)
            ) {
                Text("Select Image", style = MaterialTheme.typography.titleMedium)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Features Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = DarkSurfaceVariant),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Features",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text("• One-tap AI enhancement", color = Color.White.copy(alpha = 0.8f))
                    Text("• Remove blur & noise", color = Color.White.copy(alpha = 0.8f))
                    Text("• Upscale resolution", color = Color.White.copy(alpha = 0.8f))
                    Text("• Before/After comparison", color = Color.White.copy(alpha = 0.8f))
                }
            }
        }
    }
}