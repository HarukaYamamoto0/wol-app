package com.harukadev.wol.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.harukadev.wol.home.domain.Device
import com.harukadev.wol.home.domain.sampleDevices
import com.harukadev.wol.ui.theme.AppTheme

@Composable
fun DevicesList(
    modifier: Modifier = Modifier,
    devices: List<Device>,
    onDeviceClick: (Device) -> Unit,
    onWakeDevice: (Device) -> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text(
                text = "Devices (${devices.size})",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        items(devices) { device ->
            DeviceCard(
                device = device,
                onDeviceClick = { onDeviceClick(device) },
                onWakeDevice = { onWakeDevice(device) }
            )
        }

        // Add padding at the bottom for FAB
        item {
            Spacer(modifier = Modifier.height(70.dp))
        }
    }
}

@PreviewLightDark
@Preview
@Composable
private fun DevicesListPreview() {
    AppTheme {
        DevicesList(
            modifier = Modifier,
            devices = sampleDevices,
            onDeviceClick = {},
            onWakeDevice = {}
        )
    }
}