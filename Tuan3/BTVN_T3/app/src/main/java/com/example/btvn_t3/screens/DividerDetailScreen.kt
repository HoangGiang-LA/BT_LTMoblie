package com.example.btvn_t3.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.btvn_t3.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DividerDetailScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Divider", fontWeight = FontWeight.Bold, color = Primary) },
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
            Text("1. Đường phân cách ngang (HorizontalDivider):", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Primary)
            Spacer(modifier = Modifier.height(14.dp))

            Text("Phần giới thiệu học phần", fontSize = 15.sp)
            Spacer(modifier = Modifier.height(6.dp))
            HorizontalDivider(thickness = 1.dp, color = DividerColor)
            Spacer(modifier = Modifier.height(6.dp))

            Text("Phần lý thuyết kiến trúc Jetpack Compose", fontSize = 15.sp)
            Spacer(modifier = Modifier.height(6.dp))
            HorizontalDivider(thickness = 2.dp, color = Primary)
            Spacer(modifier = Modifier.height(6.dp))

            Text("Phần thực hành xây dựng giao diện hoàn chỉnh", fontSize = 15.sp)
            Spacer(modifier = Modifier.height(6.dp))
            HorizontalDivider(thickness = 3.dp, color = Secondary)

            Spacer(modifier = Modifier.height(30.dp))

            Text("2. Đường phân cách dọc (VerticalDivider):", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Primary)
            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                    Text("Cột Trái", fontWeight = FontWeight.Medium)
                }
                VerticalDivider(thickness = 2.dp, color = Primary)
                Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                    Text("Cột Giữa", fontWeight = FontWeight.Medium)
                }
                VerticalDivider(thickness = 2.dp, color = Secondary)
                Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                    Text("Cột Phải", fontWeight = FontWeight.Medium)
                }
            }
        }
    }
}
