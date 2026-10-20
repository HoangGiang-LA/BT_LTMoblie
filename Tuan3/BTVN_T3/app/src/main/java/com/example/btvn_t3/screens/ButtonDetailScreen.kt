package com.example.btvn_t3.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.btvn_t3.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonDetailScreen(onBack: () -> Unit) {
    var clickCount by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Button", fontWeight = FontWeight.Bold, color = Primary) },
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
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Text("1. Filled Button (Nút tiêu chuẩn):", fontWeight = FontWeight.Bold, color = Primary)
            Button(
                onClick = { clickCount++ },
                colors = ButtonDefaults.buttonColors(containerColor = Primary),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Bấm để tăng số đếm: $clickCount")
            }

            HorizontalDivider(color = DividerColor)

            Text("2. Outlined Button (Nút viền ngoài):", fontWeight = FontWeight.Bold, color = Primary)
            OutlinedButton(
                onClick = {},
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Outlined Button", color = Primary)
            }

            HorizontalDivider(color = DividerColor)

            Text("3. Text Button & Tonal Button:", fontWeight = FontWeight.Bold, color = Primary)
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                TextButton(onClick = {}) {
                    Text("Text Button")
                }
                FilledTonalButton(onClick = {}) {
                    Text("Tonal Button")
                }
            }

            HorizontalDivider(color = DividerColor)

            Text("4. Icon Button & Floating Action Button (FAB):", fontWeight = FontWeight.Bold, color = Primary)
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Favorite, "Yêu thích", tint = Primary)
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Share, "Chia sẻ", tint = Primary)
                }
                FloatingActionButton(
                    onClick = {},
                    containerColor = Primary,
                    contentColor = OnPrimary
                ) {
                    Icon(Icons.Default.Add, "FAB Thêm")
                }
                ExtendedFloatingActionButton(
                    onClick = {},
                    containerColor = Secondary,
                    contentColor = OnPrimary
                ) {
                    Icon(Icons.Default.Add, "Add")
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Tạo mới")
                }
            }

            HorizontalDivider(color = DividerColor)

            Text("5. Disabled Button:", fontWeight = FontWeight.Bold, color = Primary)
            Button(onClick = {}, enabled = false) {
                Text("Vô hiệu hóa (Disabled)")
            }
        }
    }
}
