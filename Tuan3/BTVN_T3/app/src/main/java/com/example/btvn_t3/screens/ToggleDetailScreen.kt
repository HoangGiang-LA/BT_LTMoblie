package com.example.btvn_t3.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.btvn_t3.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToggleDetailScreen(onBack: () -> Unit) {
    var wifiEnabled by remember { mutableStateOf(true) }
    var bluetoothEnabled by remember { mutableStateOf(false) }
    var darkMode by remember { mutableStateOf(false) }
    var notifications by remember { mutableStateOf(true) }
    var airplaneMode by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Toggle (Switch)", fontWeight = FontWeight.Bold, color = Primary) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back", tint = Primary)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Surface)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text("Cài đặt nhanh hệ thống:", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Primary)
            Spacer(modifier = Modifier.height(16.dp))

            ToggleRowItem("Wi-Fi", Icons.Default.Wifi, wifiEnabled) { wifiEnabled = it }
            ToggleRowItem("Bluetooth", Icons.Default.Bluetooth, bluetoothEnabled) { bluetoothEnabled = it }
            ToggleRowItem("Chế độ tối (Dark Mode)", Icons.Default.DarkMode, darkMode) { darkMode = it }
            ToggleRowItem("Thông báo ứng dụng", Icons.Default.Notifications, notifications) { notifications = it }
            ToggleRowItem("Chế độ máy bay", Icons.Default.AirplanemodeActive, airplaneMode) { airplaneMode = it }
        }
    }
}

@Composable
private fun ToggleRowItem(
    title: String,
    icon: ImageVector,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, title, tint = Primary, modifier = Modifier.size(26.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Text(title, fontSize = 15.sp, fontWeight = FontWeight.Medium, modifier = Modifier.weight(1f))
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Surface,
                checkedTrackColor = Primary
            )
        )
    }
    HorizontalDivider(color = DividerColor)
}
