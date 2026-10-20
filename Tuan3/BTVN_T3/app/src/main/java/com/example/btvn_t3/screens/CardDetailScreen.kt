package com.example.btvn_t3.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.btvn_t3.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardDetailScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Card", fontWeight = FontWeight.Bold, color = Primary) },
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
                .padding(20.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("1. Filled Card (Card chuẩn nền phẳng):", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Primary)
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = CardBackground)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Thông báo học vụ", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("Lịch thi kết thúc học phần môn Lập trình thiết bị di động sẽ được công bố vào tuần sau.", fontSize = 13.sp, color = SubText)
                }
            }

            Text("2. Elevated Card (Card đổ bóng nổi 3D):", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Primary)
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Khóa học Jetpack Compose", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Primary)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("Xây dựng giao diện ứng dụng Android hiện đại hoàn toàn bằng mã khai báo Kotlin.", fontSize = 13.sp, color = SubText)
                }
            }

            Text("3. Outlined Card (Card phong cách viền mỏng):", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Primary)
            OutlinedCard(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Tương tác bài đăng", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("Người dùng có thể tương tác với các nút hành động bên dưới thẻ.", fontSize = 13.sp, color = SubText)
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        IconButton(onClick = {}) {
                            Icon(Icons.Default.Favorite, "Like", tint = Primary)
                        }
                        IconButton(onClick = {}) {
                            Icon(Icons.Default.Share, "Share", tint = Secondary)
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        IconButton(onClick = {}) {
                            Icon(Icons.Default.Bookmark, "Bookmark")
                        }
                    }
                }
            }
        }
    }
}
