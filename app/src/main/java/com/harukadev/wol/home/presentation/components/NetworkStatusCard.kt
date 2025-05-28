package com.harukadev.wol.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.harukadev.wol.R
import com.harukadev.wol.ui.theme.AppTheme

@Composable
fun NetworkStatusCard(
    modifier: Modifier = Modifier,
    devicesCount: Int,
    onlineCount: Int,
    isScanning: Boolean
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Network Status",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = if (isScanning) "Scanning..." else "$onlineCount/$devicesCount devices online",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
                )
            }

            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(
                        if (onlineCount > 0) Color.Green.copy(alpha = 0.2f)
                        else Color.Gray.copy(alpha = 0.2f)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = if (isScanning) ImageVector.vectorResource(R.drawable.arrows_clockwise)
                        else ImageVector.vectorResource(R.drawable.wifi_high),
                    contentDescription = null,
                    tint = if (onlineCount > 0) Color.Green else Color.Gray,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@PreviewLightDark
@Preview
@Composable
private fun NetworkStatusCardPreview() {
    AppTheme {
        NetworkStatusCard(
            modifier = Modifier,
            devicesCount = 9,
            onlineCount = 3,
            isScanning = false
        )
    }
}