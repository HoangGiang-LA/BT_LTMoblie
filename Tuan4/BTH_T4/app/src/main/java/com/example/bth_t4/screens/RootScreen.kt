package com.example.bth_t4.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bth_t4.ui.theme.*

@Composable
fun RootScreen(onPush: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.weight(1f))

            // Logo khối lục giác Navigation
            HexagonLogo(modifier = Modifier.size(110.dp))

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = "Navigation",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = DarkText
            )

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "is a framework that simplifies the\nimplementation of navigation between different\nUI components (activities, fragments, or\ncomposables) in an app",
                fontSize = 13.sp,
                color = SubText,
                textAlign = TextAlign.Center,
                lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = onPush,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(26.dp),
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue)
            ) {
                Text(
                    text = "PUSH",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun HexagonLogo(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val cx = w / 2f
        val cy = h / 2f
        val r = w * 0.45f

        // Top Face (Xanh lá)
        val topPath = Path().apply {
            moveTo(cx, cy - r)
            lineTo(cx + r * 0.866f, cy - r * 0.5f)
            lineTo(cx, cy)
            lineTo(cx - r * 0.866f, cy - r * 0.5f)
            close()
        }
        drawPath(topPath, color = Color(0xFF2C9F67))

        // Right Face (Xanh lam)
        val rightPath = Path().apply {
            moveTo(cx, cy)
            lineTo(cx + r * 0.866f, cy - r * 0.5f)
            lineTo(cx + r * 0.866f, cy + r * 0.5f)
            lineTo(cx, cy + r)
            close()
        }
        drawPath(rightPath, color = Color(0xFF388AF6))

        // Left Face (Xanh đậm)
        val leftPath = Path().apply {
            moveTo(cx, cy)
            lineTo(cx, cy + r)
            lineTo(cx - r * 0.866f, cy + r * 0.5f)
            lineTo(cx - r * 0.866f, cy - r * 0.5f)
            close()
        }
        drawPath(leftPath, color = Color(0xFF1E355B))
    }
}
