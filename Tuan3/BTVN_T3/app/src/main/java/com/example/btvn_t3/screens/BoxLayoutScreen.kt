package com.example.btvn_t3.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.btvn_t3.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BoxLayoutScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Box Layout", fontWeight = FontWeight.Bold, color = Primary) },
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
            Text("Box xếp đè các phần tử lên nhau (Overlapping Layers):", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Primary)
            Spacer(modifier = Modifier.height(14.dp))

            // Mô phỏng 3 khối màu đỏ/cam xếp đè lệch nhau như slide
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(CardBackground),
                contentAlignment = Alignment.Center
            ) {
                // Lớp 1 (Dưới cùng)
                Box(
                    modifier = Modifier
                        .size(140.dp)
                        .offset(x = (-20).dp, y = (-15).dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFFFFAB91))
                )
                // Lớp 2 (Trung gian)
                Box(
                    modifier = Modifier
                        .size(110.dp)
                        .offset(x = 20.dp, y = 20.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFFFF7043))
                )
                // Lớp 3 (Trên cùng)
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFFE64A19)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Top", color = Surface, fontWeight = FontWeight.Bold)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
            HorizontalDivider(color = DividerColor)
            Spacer(modifier = Modifier.height(20.dp))

            Text("Ứng dụng Box làm Icon kèm huy hiệu thông báo (Badge):", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Primary)
            Spacer(modifier = Modifier.height(14.dp))

            Box(
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(LightBlue),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Bell",
                    tint = DarkBlue,
                    modifier = Modifier.size(36.dp)
                )

                // Huy hiệu số 9+ ở góc trên bên phải
                Box(
                    modifier = Modifier
                        .size(22.dp)
                        .align(Alignment.TopEnd)
                        .offset(x = 4.dp, y = (-4).dp)
                        .clip(CircleShape)
                        .background(Color(0xFFD32F2F)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("9+", color = Surface, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
