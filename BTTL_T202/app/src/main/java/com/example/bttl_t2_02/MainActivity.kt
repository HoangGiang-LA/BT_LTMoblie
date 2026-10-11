package com.example.bttl_t2_02

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtScore = findViewById<TextView>(R.id.txtScore)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        val testContainer =
            findViewById<LinearLayout>(R.id.testContainer)
//1. Diem trung binh
        val score = 8.5
//2. Xep loai hoc luc
        val result = classify(score)
        txtScore.text = score.toString()
        txtResult.text = result

        // Đổi màu theo xếp loại
        txtResult.setTextColor(getGradeColor(result))

        // 3. Danh sách điểm kiểm tra thêm
        val testScores = listOf(9.0, 7.0, 5.5, 3.0, 11.0)

        // 4. Dùng for để hiển thị kết quả
        for (testScore in testScores) {

            val classification = classify(testScore)

            // Một dòng kết quả
            val row = LinearLayout(this)
            row.orientation = LinearLayout.HORIZONTAL
            row.gravity = Gravity.CENTER_VERTICAL
            row.setPadding(4, dp(12), 4, dp(12))

            val rowParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            // Hiển thị điểm
            val txtTestScore = TextView(this)

            txtTestScore.text =
                "Điểm ${formatScore(testScore)}"

            txtTestScore.textSize = 15f
            txtTestScore.setTextColor(Color.DKGRAY)

            val scoreParams = LinearLayout.LayoutParams(
                0,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                1f
            )

            row.addView(txtTestScore, scoreParams)

            // Hiển thị xếp loại
            val txtGrade = TextView(this)

            txtGrade.text = classification
            txtGrade.textSize = 14f
            txtGrade.setTypeface(null, Typeface.BOLD)
            txtGrade.setTextColor(
                getGradeColor(classification)
            )

            row.addView(txtGrade)

            // Thêm dòng vào giao diện
            testContainer.addView(row, rowParams)
        }
    }

    // Hàm phân loại bằng if / else
    private fun classify(score: Double): String {

        return if (score < 0 || score > 10) {
            "Không hợp lệ"
        } else if (score >= 8.0) {
            "Giỏi"
        } else if (score >= 6.5) {
            "Khá"
        } else if (score >= 5.0) {
            "Trung bình"
        } else {
            "Yếu"
        }
    }

    // Hàm chọn màu xếp loại
    private fun getGradeColor(grade: String): Int {

        return when (grade) {
            "Giỏi" -> Color.rgb(52, 128, 77)
            "Khá" -> Color.rgb(54, 103, 171)
            "Trung bình" -> Color.rgb(171, 122, 55)
            "Yếu" -> Color.rgb(187, 85, 73)
            else -> Color.GRAY
        }
    }

    // Hiển thị 9.0 thành 9, giữ 5.5
    private fun formatScore(score: Double): String {

        return if (score == score.toInt().toDouble()) {
            score.toInt().toString()
        } else {
            score.toString()
        }
    }

    // Đổi dp sang pixel
    private fun dp(value: Int): Int {
        return (value * resources.displayMetrics.density).toInt()
    }
}
