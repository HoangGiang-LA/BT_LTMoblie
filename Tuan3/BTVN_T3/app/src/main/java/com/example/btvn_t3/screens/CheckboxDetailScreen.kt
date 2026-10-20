package com.example.btvn_t3.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.btvn_t3.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckboxDetailScreen(onBack: () -> Unit) {
    val skills = listOf("Jetpack Compose", "Kotlin Coroutines", "Android Studio", "Material Design 3")
    val checkedList = remember { mutableStateListOf(true, false, true, false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Checkbox", fontWeight = FontWeight.Bold, color = Primary) },
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
            Text("Chọn kỹ năng bạn đã nắm vững:", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Primary)
            Spacer(modifier = Modifier.height(10.dp))

            skills.forEachIndexed { index, skill ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
                ) {
                    Checkbox(
                        checked = checkedList[index],
                        onCheckedChange = { checkedList[index] = it },
                        colors = CheckboxDefaults.colors(checkedColor = Primary)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(skill, fontSize = 15.sp)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            val selectedCount = checkedList.count { it }
            Text(
                text = "Đã chọn $selectedCount/${skills.size} kỹ năng",
                color = Secondary,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(24.dp))
            HorizontalDivider(color = DividerColor)
            Spacer(modifier = Modifier.height(20.dp))

            Text("TriStateCheckbox (Chọn tất cả):", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Primary)
            Spacer(modifier = Modifier.height(10.dp))

            val allChecked = checkedList.all { it }
            val noneChecked = checkedList.none { it }
            val parentState = when {
                allChecked -> ToggleableState.On
                noneChecked -> ToggleableState.Off
                else -> ToggleableState.Indeterminate
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                TriStateCheckbox(
                    state = parentState,
                    onClick = {
                        val target = parentState != ToggleableState.On
                        for (i in checkedList.indices) {
                            checkedList[i] = target
                        }
                    },
                    colors = CheckboxDefaults.colors(checkedColor = Primary)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Chọn tất cả các mục", fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
            }
        }
    }
}
