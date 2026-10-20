package com.example.btvn_t3.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.btvn_t3.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RadioButtonDetailScreen(onBack: () -> Unit) {
    var selectedYear by remember { mutableStateOf("Năm 3 (K22)") }
    val years = listOf("Năm 1 (K24)", "Năm 2 (K23)", "Năm 3 (K22)", "Năm 4 (K21)")

    var selectedMajor by remember { mutableStateOf("Công nghệ thông tin") }
    val majors = listOf("Công nghệ thông tin", "Kỹ thuật ô tô", "Logistics & Vận tải")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("RadioButton", fontWeight = FontWeight.Bold, color = Primary) },
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
            Text("Chọn khóa sinh viên UTH:", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Primary)
            Spacer(modifier = Modifier.height(8.dp))

            years.forEach { year ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (selectedYear == year),
                            onClick = { selectedYear = year },
                            role = Role.RadioButton
                        )
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (selectedYear == year),
                        onClick = null,
                        colors = RadioButtonDefaults.colors(selectedColor = Primary)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(year, fontSize = 15.sp)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text("Đang chọn: $selectedYear", color = Secondary, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(24.dp))
            HorizontalDivider(color = DividerColor)
            Spacer(modifier = Modifier.height(20.dp))

            Text("Chọn ngành học:", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Primary)
            Spacer(modifier = Modifier.height(8.dp))

            majors.forEach { major ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (selectedMajor == major),
                            onClick = { selectedMajor = major },
                            role = Role.RadioButton
                        )
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (selectedMajor == major),
                        onClick = null,
                        colors = RadioButtonDefaults.colors(selectedColor = Secondary)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(major, fontSize = 15.sp)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text("Đang chọn: $selectedMajor", color = Secondary, fontWeight = FontWeight.Bold)
        }
    }
}
