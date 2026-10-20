package com.example.btvn_t3.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.btvn_t3.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SliderDetailScreen(onBack: () -> Unit) {
    var continuousValue by remember { mutableFloatStateOf(0.4f) }
    var discreteValue by remember { mutableFloatStateOf(50f) }
    var rangeValues by remember { mutableStateOf(20f..75f) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Slider", fontWeight = FontWeight.Bold, color = Primary) },
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
            // Slider liên tục
            Text("1. Continuous Slider (Thanh trượt liên tục):", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Primary)
            Spacer(modifier = Modifier.height(6.dp))
            Text("Mức độ sáng màn hình: ${(continuousValue * 100).toInt()}%", fontSize = 14.sp, color = SubText)
            Slider(
                value = continuousValue,
                onValueChange = { continuousValue = it },
                colors = SliderDefaults.colors(thumbColor = Primary, activeTrackColor = Primary)
            )

            Spacer(modifier = Modifier.height(24.dp))
            HorizontalDivider(color = DividerColor)
            Spacer(modifier = Modifier.height(20.dp))

            // Slider từng bước (Discrete)
            Text("2. Discrete Slider (Theo từng nấc cố định):", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Primary)
            Spacer(modifier = Modifier.height(6.dp))
            Text("Âm lượng: ${discreteValue.toInt()}/100", fontSize = 14.sp, color = SubText)
            Slider(
                value = discreteValue,
                onValueChange = { discreteValue = it },
                valueRange = 0f..100f,
                steps = 9,
                colors = SliderDefaults.colors(thumbColor = Secondary, activeTrackColor = Secondary)
            )

            Spacer(modifier = Modifier.height(24.dp))
            HorizontalDivider(color = DividerColor)
            Spacer(modifier = Modifier.height(20.dp))

            // RangeSlider (Khoảng giá trị)
            Text("3. RangeSlider (Chọn dải khoảng cách):", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Primary)
            Spacer(modifier = Modifier.height(6.dp))
            Text("Khoảng lọc: ${rangeValues.start.toInt()} đến ${rangeValues.endInclusive.toInt()}", fontSize = 14.sp, color = SubText)
            RangeSlider(
                value = rangeValues,
                onValueChange = { rangeValues = it },
                valueRange = 0f..100f,
                colors = SliderDefaults.colors(thumbColor = DarkBlue, activeTrackColor = DarkBlue)
            )
        }
    }
}
