package com.example.btvn_t3.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.btvn_t3.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextDetailScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Text Detail", fontWeight = FontWeight.Bold, color = Primary) },
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
            // Mẫu The quick Brown fox jumps over the lazy dog giống hệt hình bài tập
            Text(
                buildAnnotatedString {
                    append("The quick ")
                    withStyle(SpanStyle(color = Color(0xFFD84315), fontSize = 32.sp, fontWeight = FontWeight.Bold)) {
                        append("Brown\n")
                    }
                    append("fox ")
                    withStyle(SpanStyle(letterSpacing = 6.sp)) {
                        append("j u m p s")
                    }
                    append(" ")
                    withStyle(SpanStyle(fontWeight = FontWeight.Black, fontSize = 26.sp)) {
                        append("over\n")
                    }
                    withStyle(SpanStyle(textDecoration = TextDecoration.Underline)) {
                        append("the")
                    }
                    append(" ")
                    withStyle(SpanStyle(fontStyle = FontStyle.Italic, fontWeight = FontWeight.SemiBold)) {
                        append("lazy")
                    }
                    append(" dog.")
                },
                fontSize = 24.sp,
                lineHeight = 42.sp,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            HorizontalDivider(color = DividerColor)
            Spacer(modifier = Modifier.height(20.dp))

            Text("Các biến thể phong cách Text đa dạng:", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Primary)
            Spacer(modifier = Modifier.height(12.dp))

            Text("1. In đậm (Bold Text)", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(6.dp))
            Text("2. In nghiêng (Italic Text)", fontStyle = FontStyle.Italic, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(6.dp))
            Text("3. Gạch chân (Underline Text)", textDecoration = TextDecoration.Underline, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(6.dp))
            Text("4. Gạch ngang (Strikethrough)", textDecoration = TextDecoration.LineThrough, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(6.dp))
            Text("5. Phông chữ Monospace", fontFamily = FontFamily.Monospace, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(6.dp))
            Text("6. Phông chữ Serif cổ điển", fontFamily = FontFamily.Serif, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(6.dp))
            Text("7. Màu sắc tuỳ biến (Pink Theme)", color = Color(0xFFE91E63), fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(6.dp))
            Text("8. Giới hạn số dòng và tràn dấu ...: Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                maxLines = 1,
                fontSize = 14.sp,
                color = SubText
            )
        }
    }
}
