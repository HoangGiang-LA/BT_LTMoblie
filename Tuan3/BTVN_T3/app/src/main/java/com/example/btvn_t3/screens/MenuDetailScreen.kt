package com.example.btvn_t3.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.btvn_t3.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuDetailScreen(onBack: () -> Unit) {
    var topMenuExpanded by remember { mutableStateOf(false) }
    var contextMenuExpanded by remember { mutableStateOf(false) }
    var selectedAction by remember { mutableStateOf("Chưa thực hiện hành động") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Menu", fontWeight = FontWeight.Bold, color = Primary) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back", tint = Primary)
                    }
                },
                actions = {
                    Box {
                        IconButton(onClick = { topMenuExpanded = true }) {
                            Icon(Icons.Default.MoreVert, "Tùy chọn menu")
                        }
                        DropdownMenu(
                            expanded = topMenuExpanded,
                            onDismissRequest = { topMenuExpanded = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text("Cài đặt hệ thống") },
                                onClick = {
                                    selectedAction = "Đã chọn: Cài đặt hệ thống"
                                    topMenuExpanded = false
                                },
                                leadingIcon = { Icon(Icons.Default.Settings, "Cài đặt") }
                            )
                            DropdownMenuItem(
                                text = { Text("Chia sẻ ứng dụng") },
                                onClick = {
                                    selectedAction = "Đã chọn: Chia sẻ ứng dụng"
                                    topMenuExpanded = false
                                },
                                leadingIcon = { Icon(Icons.Default.Share, "Chia sẻ") }
                            )
                            HorizontalDivider()
                            DropdownMenuItem(
                                text = { Text("Thông tin phiên bản") },
                                onClick = {
                                    selectedAction = "Đã chọn: Thông tin phiên bản (v1.0)"
                                    topMenuExpanded = false
                                },
                                leadingIcon = { Icon(Icons.Default.Info, "Thông tin") }
                            )
                        }
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
            Text("1. Dropdown Menu trên TopAppBar:", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Primary)
            Spacer(modifier = Modifier.height(6.dp))
            Text("Hãy bấm vào biểu tượng ba chấm ⋮ ở góc trên bên phải để xem Menu.", fontSize = 14.sp, color = SubText)

            Spacer(modifier = Modifier.height(20.dp))
            Text("Hành động gần nhất: $selectedAction", fontWeight = FontWeight.Bold, color = Secondary)

            Spacer(modifier = Modifier.height(24.dp))
            HorizontalDivider(color = DividerColor)
            Spacer(modifier = Modifier.height(20.dp))

            Text("2. Context Menu (Menu nội dung tại chỗ):", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Primary)
            Spacer(modifier = Modifier.height(10.dp))

            Box {
                Button(
                    onClick = { contextMenuExpanded = true },
                    colors = ButtonDefaults.buttonColors(containerColor = Primary)
                ) {
                    Icon(Icons.Default.Menu, "Menu")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Mở Menu Thao tác")
                }

                DropdownMenu(
                    expanded = contextMenuExpanded,
                    onDismissRequest = { contextMenuExpanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("Sao chép liên kết") },
                        onClick = {
                            selectedAction = "Đã bấm: Sao chép liên kết"
                            contextMenuExpanded = false
                        },
                        leadingIcon = { Icon(Icons.Default.ContentCopy, "Sao chép") }
                    )
                    DropdownMenuItem(
                        text = { Text("Chỉnh sửa nội dung") },
                        onClick = {
                            selectedAction = "Đã bấm: Chỉnh sửa"
                            contextMenuExpanded = false
                        },
                        leadingIcon = { Icon(Icons.Default.Edit, "Sửa") }
                    )
                    HorizontalDivider()
                    DropdownMenuItem(
                        text = { Text("Xóa mục này") },
                        onClick = {
                            selectedAction = "Đã bấm: Xóa"
                            contextMenuExpanded = false
                        },
                        leadingIcon = { Icon(Icons.Default.Delete, "Xóa") }
                    )
                }
            }
        }
    }
}
