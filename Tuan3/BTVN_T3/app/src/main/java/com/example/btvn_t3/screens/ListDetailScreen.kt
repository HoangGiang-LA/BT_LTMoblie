package com.example.btvn_t3.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.btvn_t3.ui.theme.*

data class StudentInfo(val name: String, val mssv: String, val faculty: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListDetailScreen(onBack: () -> Unit) {
    val sampleStudents = listOf(
        StudentInfo("Nguyễn Văn A", "2251120001", "Khoa CNTT"),
        StudentInfo("Trần Thị B", "2251120002", "Khoa CNTT"),
        StudentInfo("Lê Hoàng C", "2251080015", "Khoa Điện - Điện tử"),
        StudentInfo("Phạm Minh D", "2251050020", "Khoa Kinh tế vận tải"),
        StudentInfo("Đỗ Mai E", "2251120033", "Khoa CNTT"),
        StudentInfo("Vũ Quốc F", "2251020045", "Khoa Hàng hải"),
        StudentInfo("Hoàng Trọng G", "2251120058", "Khoa CNTT"),
        StudentInfo("Bùi Thùy H", "2251050060", "Khoa Kinh tế vận tải")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("List (LazyColumn)", fontWeight = FontWeight.Bold, color = Primary) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back", tint = Primary)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Surface)
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(vertical = 12.dp)
        ) {
            item {
                Text(
                    text = "Danh sách sinh viên UTH (LazyColumn cuộn mượt mà):",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Primary,
                    modifier = Modifier.padding(bottom = 6.dp)
                )
            }

            items(sampleStudents) { student ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = CardBackground)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            modifier = Modifier.size(44.dp).clip(CircleShape),
                            color = Primary
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(Icons.Default.School, "Student", tint = OnPrimary)
                            }
                        }
                        Spacer(modifier = Modifier.width(14.dp))
                        Column {
                            Text(student.name, fontWeight = FontWeight.Bold, fontSize = 15.sp, color = OnBackground)
                            Text("MSSV: ${student.mssv} • ${student.faculty}", fontSize = 13.sp, color = SubText)
                        }
                    }
                }
            }
        }
    }
}
