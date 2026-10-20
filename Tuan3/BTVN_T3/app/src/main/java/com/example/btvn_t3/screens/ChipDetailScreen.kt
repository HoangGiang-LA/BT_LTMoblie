package com.example.btvn_t3.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tag
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
fun ChipDetailScreen(onBack: () -> Unit) {
    var isFilterSelected by remember { mutableStateOf(true) }
    var selectedCategory by remember { mutableStateOf("Android") }
    val categories = listOf("Android", "iOS", "Flutter", "React Native")
    var isInputChipVisible by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Chips / Tag", fontWeight = FontWeight.Bold, color = Primary) },
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
            // 1. FilterChip
            Text(
                text = "1. Thẻ lọc lựa chọn (FilterChip):",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Primary
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FilterChip(
                    selected = isFilterSelected,
                    onClick = { isFilterSelected = !isFilterSelected },
                    label = { Text("Đã kích hoạt") },
                    leadingIcon = if (isFilterSelected) {
                        { Icon(Icons.Default.Check, "Checked", modifier = Modifier.size(18.dp)) }
                    } else null
                )

                FilterChip(
                    selected = !isFilterSelected,
                    onClick = { isFilterSelected = !isFilterSelected },
                    label = { Text("Chưa xem") }
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(color = DividerColor)
            Spacer(modifier = Modifier.height(10.dp))

            // 2. Single Select FilterChips
            Text(
                text = "2. Chọn danh mục theo Chip:",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Primary
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                categories.take(3).forEach { cat ->
                    FilterChip(
                        selected = (selectedCategory == cat),
                        onClick = { selectedCategory = cat },
                        label = { Text(cat) }
                    )
                }
            }
            Text("Đang chọn công nghệ: $selectedCategory", fontSize = 13.sp, color = Secondary, fontWeight = FontWeight.SemiBold)

            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(color = DividerColor)
            Spacer(modifier = Modifier.height(10.dp))

            // 3. AssistChip & SuggestionChip
            Text(
                text = "3. Thẻ trợ giúp và gợi ý (AssistChip & SuggestionChip):",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Primary
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                AssistChip(
                    onClick = {},
                    label = { Text("Yêu thích") },
                    leadingIcon = { Icon(Icons.Default.Favorite, "Like", tint = Color(0xFFE91E63), modifier = Modifier.size(18.dp)) }
                )
                SuggestionChip(
                    onClick = {},
                    label = { Text("Gợi ý bài tập") },
                    icon = { Icon(Icons.Default.Tag, "Tag", modifier = Modifier.size(18.dp)) }
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(color = DividerColor)
            Spacer(modifier = Modifier.height(10.dp))

            // 4. InputChip có nút xoá
            Text(
                text = "4. Thẻ nhập liệu có nút hủy (InputChip):",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Primary
            )
            if (isInputChipVisible) {
                InputChip(
                    selected = false,
                    onClick = {},
                    label = { Text("Từ khóa: Jetpack Compose") },
                    trailingIcon = {
                        IconButton(
                            onClick = { isInputChipVisible = false },
                            modifier = Modifier.size(18.dp)
                        ) {
                            Icon(Icons.Default.Close, "Remove")
                        }
                    }
                )
            } else {
                TextButton(onClick = { isInputChipVisible = true }) {
                    Text("+ Phục hồi từ khóa vừa xóa")
                }
            }
        }
    }
}
