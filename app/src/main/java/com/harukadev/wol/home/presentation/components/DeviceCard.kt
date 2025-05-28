package com.harukadev.wol.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.harukadev.wol.R
import com.harukadev.wol.home.domain.Device
import com.harukadev.wol.home.domain.sampleDevices
import com.harukadev.wol.ui.theme.AppTheme
import com.harukadev.wol.ui.theme.grayColor

@Composable
fun DeviceCard(
    modifier: Modifier = Modifier,
    device: Device,
    onDeviceClick: () -> Unit,
    onWakeDevice: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onDeviceClick() },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Device Icon
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(device.category.icon),
                    contentDescription = device.category.displayName,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Device Info
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = device.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = device.ipAddress,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
                Text(
                    text = if (device.isOnline) "Online" else "Last seen: ${device.lastSeen}",
                    style = MaterialTheme.typography.bodySmall,
                    color = if (device.isOnline) Color.Green else Color.Gray
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Wake Button
            IconButton(
                onClick = onWakeDevice,
                enabled = !device.isOnline
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.power),
                    contentDescription = "Wake Device",
                    tint = if (device.isOnline)
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)
                    else
                        MaterialTheme.colorScheme.primary
                )
            }

            IconButton(
                onClick = onWakeDevice,
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.dots_three_outline_vertical_fill),
                    contentDescription = "Wake Device",
                    tint = grayColor
                )
            }
        }
    }
}

@PreviewLightDark
@Preview
@Composable
private fun DeviceCardPreview() {
    AppTheme {
        DeviceCard(
            modifier = Modifier,
            device = sampleDevices[0],
            onDeviceClick = {},
            onWakeDevice = { }
        )
    }
}