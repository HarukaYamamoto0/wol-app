package com.harukadev.wol.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.harukadev.wol.R
import com.harukadev.wol.ui.theme.AppTheme
import com.harukadev.wol.ui.theme.darkGreen

@Composable
fun EmptyDevicesList(
    modifier: Modifier = Modifier,
    onAddDevice: () -> Unit,
    onScanNetwork: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.globe_x),
            contentDescription = "No devices found",
            modifier = Modifier.size(72.dp),
            tint = darkGreen
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "No devices found",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )

        Text(
            text = "Scan your network to get started or add devices manually",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
            modifier = Modifier.padding(top = 8.dp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Button(
                onClick = onScanNetwork,
                modifier = Modifier.fillMaxWidth().weight(1f)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.network),
                    contentDescription = null,
                    modifier=Modifier.size(23.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Scan Network")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = onAddDevice,
                modifier = Modifier.fillMaxWidth(1f).weight(1f)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier=Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Add Manually")
            }
        }
    }
}

@PreviewLightDark
@Preview
@Composable
private fun EmptyDevicesListPreview() {
    AppTheme {
        EmptyDevicesList(
            onAddDevice = {},
            onScanNetwork = {}
        )
    }
}