package com.example.btvn_t3.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
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
fun ProgressDetailScreen(onBack: () -> Unit) {
    var progressValue by remember { mutableFloatStateOf(0.65f) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Progress Indicator", fontWeight = FontWeight.Bold, color = Primary) },
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
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 1. Circular Progress Vô tận
            Text(
                text = "1. Vòng tròn tải xoay vòng (Circular Indeterminate):",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Primary
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircularProgressIndicator(color = Primary)
                CircularProgressIndicator(color = Secondary, strokeWidth = 5.dp)
                Text("Đang tải dữ liệu...", fontSize = 14.sp, color = SubText)
            }

            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(color = DividerColor)
            Spacer(modifier = Modifier.height(10.dp))

            // 2. Linear Progress Vô tận
            Text(
                text = "2. Thanh tiến trình chạy liên tục (Linear Indeterminate):",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Primary
            )
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
                color = Primary,
                trackColor = LightBlue
            )

            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(color = DividerColor)
            Spacer(modifier = Modifier.height(10.dp))

            // 3. Tiến trình có phần trăm xác định (Determinate)
            Text(
                text = "3. Tiến trình theo tỷ lệ phần trăm (${(progressValue * 100).toInt()}%):",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Primary
            )

            LinearProgressIndicator(
                progress = { progressValue },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp),
                color = Secondary,
                trackColor = CardBackground
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircularProgressIndicator(
                    progress = { progressValue },
                    color = Secondary,
                    modifier = Modifier.size(50.dp)
                )

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button(
                        onClick = { if (progressValue > 0.1f) progressValue -= 0.1f },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Primary)
                    ) {
                        Text("-10%")
                    }
                    Button(
                        onClick = { if (progressValue < 1.0f) progressValue += 0.1f },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Primary)
                    ) {
                        Text("+10%")
                    }
                }
            }
        }
    }
}
