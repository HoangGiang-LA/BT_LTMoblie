package com.example.btvn_t3.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.btvn_t3.ui.theme.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldDetailScreen(onBack: () -> Unit) {
    var selectedBottomTab by remember { mutableIntStateOf(0) }
    val bottomTabs = listOf("Trang chủ", "Khám phá", "Cá nhân")
    val bottomIcons = listOf(Icons.Default.Home, Icons.Default.Explore, Icons.Default.Person)

    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Scaffold Container", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back", tint = Primary)
                    }
                },
                actions = {
                    IconButton(onClick = {
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar("Bạn vừa bấm nút Cài đặt trên TopBar")
                        }
                    }) {
                        Icon(Icons.Default.Settings, "Cài đặt")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Surface)
            )
        },
        bottomBar = {
            NavigationBar(containerColor = Surface) {
                bottomTabs.forEachIndexed { index, title ->
                    NavigationBarItem(
                        selected = (selectedBottomTab == index),
                        onClick = { selectedBottomTab = index },
                        icon = { Icon(bottomIcons[index], title) },
                        label = { Text(title) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Primary,
                            indicatorColor = LightBlue
                        )
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("Đã kích hoạt Floating Action Button!")
                    }
                },
                containerColor = Primary,
                contentColor = OnPrimary
            ) {
                Icon(Icons.Default.Add, "FAB Add")
            }
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(20.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Text(
                text = "Scaffold là khung chứa tổng hợp UI Android:",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Primary
            )

            val parts = listOf(
                "TopAppBar" to "Thanh tiêu đề hiển thị nút Back và các nút chức năng Action",
                "BottomNavigationBar" to "Thanh điều hướng chuyển tab ở đáy màn hình",
                "FloatingActionButton" to "Nút hành động nổi ở góc dưới",
                "SnackbarHost" to "Khung thông báo nhanh tương tác người dùng",
                "Content Body" to "Vùng nội dung ứng dụng tự động co giãn theo padding"
            )

            parts.forEach { (title, desc) ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = CardBackground)
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Text(title, fontWeight = FontWeight.Bold, fontSize = 15.sp, color = DarkBlue)
                        Text(desc, fontSize = 13.sp, color = SubText)
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            Text("Tab đang mở dưới thanh đáy: ${bottomTabs[selectedBottomTab]}", fontWeight = FontWeight.Bold, color = Secondary)
        }
    }
}
