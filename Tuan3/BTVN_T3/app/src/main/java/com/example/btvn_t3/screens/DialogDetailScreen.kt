package com.example.btvn_t3.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.btvn_t3.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogDetailScreen(onBack: () -> Unit) {
    var showAlertDialog by remember { mutableStateOf(false) }
    var showConfirmDialog by remember { mutableStateOf(false) }
    var dialogResult by remember { mutableStateOf("Chưa có thao tác") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dialog / Alert", fontWeight = FontWeight.Bold, color = Primary) },
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
            Text(
                text = "Hộp thoại thông báo & xác nhận (AlertDialog):",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Primary
            )

            // Nút mở AlertDialog thông báo
            Button(
                onClick = { showAlertDialog = true },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Primary)
            ) {
                Icon(Icons.Default.Info, "Info")
                Spacer(modifier = Modifier.width(8.dp))
                Text("Hiển thị thông báo (Info Dialog)")
            }

            // Nút mở Confirm Dialog
            OutlinedButton(
                onClick = { showConfirmDialog = true },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(Icons.Default.Warning, "Warning", tint = Color(0xFFD32F2F))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Hộp thoại xác nhận hành động", color = Color(0xFFD32F2F))
            }

            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(color = DividerColor)
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Kết quả tương tác gần nhất:",
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color = CategoryHeader
            )

            Card(
                colors = CardDefaults.cardColors(containerColor = CardBackground),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = dialogResult,
                    modifier = Modifier.padding(16.dp),
                    fontWeight = FontWeight.Medium,
                    color = DarkBlue
                )
            }
        }

        // 1. Alert Dialog đơn giản
        if (showAlertDialog) {
            AlertDialog(
                onDismissRequest = { showAlertDialog = false },
                icon = { Icon(Icons.Default.Info, "Info", tint = Primary) },
                title = { Text("Thông báo học phần", fontWeight = FontWeight.Bold) },
                text = {
                    Text("Bài tập xây dựng đầy đủ các thành phần UI Jetpack Compose đã được cập nhật thành công!")
                },
                confirmButton = {
                    TextButton(onClick = {
                        dialogResult = "Đã xem và đóng thông báo"
                        showAlertDialog = false
                    }) {
                        Text("Đã hiểu", fontWeight = FontWeight.Bold)
                    }
                }
            )
        }

        // 2. Confirm Dialog có 2 nút xác nhận/hủy
        if (showConfirmDialog) {
            AlertDialog(
                onDismissRequest = { showConfirmDialog = false },
                icon = { Icon(Icons.Default.Warning, "Warning", tint = Color(0xFFD32F2F)) },
                title = { Text("Xác nhận thao tác", fontWeight = FontWeight.Bold) },
                text = {
                    Text("Bạn có chắc chắn muốn làm mới toàn bộ dữ liệu mẫu trong ứng dụng này không?")
                },
                confirmButton = {
                    Button(
                        onClick = {
                            dialogResult = "✓ Người dùng đã chọn: ĐỒNG Ý"
                            showConfirmDialog = false
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD32F2F))
                    ) {
                        Text("Đồng ý")
                    }
                },
                dismissButton = {
                    OutlinedButton(onClick = {
                        dialogResult = "✗ Người dùng đã chọn: HỦY BỎ"
                        showConfirmDialog = false
                    }) {
                        Text("Hủy")
                    }
                }
            )
        }
    }
}
