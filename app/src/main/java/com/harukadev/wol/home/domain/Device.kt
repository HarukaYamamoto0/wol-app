package com.harukadev.wol.home.domain

import com.harukadev.wol.R

data class Device(
    val id: String,
    val name: String,
    val macAddress: String,
    val ipAddress: String,
    val category: DeviceCategory,
    val isOnline: Boolean,
    val lastSeen: String
)

enum class DeviceCategory(val displayName: String, val icon: Int) {
    DESKTOP("Desktop", R.drawable.desktop),
    LAPTOP("Laptop", R.drawable.laptop),
    SERVER("Server",R.drawable.hard_drives),
    OTHER("Other", R.drawable.network)
}

val sampleDevices = listOf(
    Device(
        id = "1",
        name = "Gaming PC",
        macAddress = "AA:BB:CC:DD:EE:FF",
        ipAddress = "192.168.1.100",
        category = DeviceCategory.DESKTOP,
        isOnline = true,
        lastSeen = "Now"
    ),
    Device(
        id = "2",
        name = "Work Laptop",
        macAddress = "11:22:33:44:55:66",
        ipAddress = "192.168.1.101",
        category = DeviceCategory.LAPTOP,
        isOnline = false,
        lastSeen = "2 hours ago"
    ),
    Device(
        id = "3",
        name = "Home Server",
        macAddress = "77:88:99:AA:BB:CC",
        ipAddress = "192.168.1.10",
        category = DeviceCategory.SERVER,
        isOnline = true,
        lastSeen = "Now"
    )
)