package com.harukadev.wol.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.harukadev.wol.home.domain.Device
import com.harukadev.wol.home.domain.sampleDevices
import com.harukadev.wol.home.presentation.components.DevicesList
import com.harukadev.wol.home.presentation.components.NetworkStatusCard
import com.harukadev.wol.ui.theme.AppTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    devices: List<Device> = listOf(),
    onDeviceClick: (Device) -> Unit = {},
    onWakeDevice: (Device) -> Unit = {},
    onAddDevice: () -> Unit = {},
    onScanNetwork: () -> Unit = {},
    isScanning: Boolean = false)
{
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (devices.isEmpty()) {
            EmptyDevicesList(
                onAddDevice = onAddDevice,
                onScanNetwork = onScanNetwork
            )
        } else {
            NetworkStatusCard(
                devicesCount = devices.size,
                onlineCount = devices.count { it.isOnline },
                isScanning = isScanning
            )

            Spacer(modifier = Modifier.height(16.dp))

            DevicesList(
                devices = devices,
                onDeviceClick = onDeviceClick,
                onWakeDevice = onWakeDevice
            )
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    AppTheme {
        HomeScreen(
            devices = sampleDevices
        )
    }
}