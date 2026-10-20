package com.example.btvn_t3.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.btvn_t3.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldDetailScreen(onBack: () -> Unit) {
    var basicText by remember { mutableStateOf("") }
    var emailText by remember { mutableStateOf("") }
    var searchText by remember { mutableStateOf("") }
    var multilineText by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("TextField", fontWeight = FontWeight.Bold, color = Primary) },
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
            // Khung TextField bo góc như ảnh bài tập
            OutlinedTextField(
                value = basicText,
                onValueChange = { basicText = it },
                label = { Text("Thông tin nhập") },
                placeholder = { Text("Nhập nội dung bất kỳ...") },
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Dòng chữ đỏ báo tự động cập nhật giống slide
            Text(
                text = if (basicText.isEmpty()) "Tự động cập nhật dữ liệu theo textfield" else "Dữ liệu hiện tại: $basicText",
                color = Color(0xFFD32F2F),
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(24.dp))
            HorizontalDivider(color = DividerColor)
            Spacer(modifier = Modifier.height(20.dp))

            Text("Các kiểu biến thể TextField phong phú:", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Primary)
            Spacer(modifier = Modifier.height(14.dp))

            // Email TextField với Icon
            OutlinedTextField(
                value = emailText,
                onValueChange = { emailText = it },
                label = { Text("Địa chỉ Email") },
                leadingIcon = { Icon(Icons.Default.Email, "Email", tint = Primary) },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Search TextField bo tròn
            TextField(
                value = searchText,
                onValueChange = { searchText = it },
                placeholder = { Text("Tìm kiếm thành phần...") },
                leadingIcon = { Icon(Icons.Default.Search, "Search") },
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Disabled field
            OutlinedTextField(
                value = "Giá trị chỉ đọc (Disabled Field)",
                onValueChange = {},
                label = { Text("Trạng thái") },
                enabled = false,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Multiline
            OutlinedTextField(
                value = multilineText,
                onValueChange = { multilineText = it },
                label = { Text("Ghi chú mô tả (Nhiều dòng)") },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth().height(110.dp),
                maxLines = 4
            )
        }
    }
}
