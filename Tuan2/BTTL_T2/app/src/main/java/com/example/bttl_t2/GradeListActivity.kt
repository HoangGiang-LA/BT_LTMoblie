package com.example.bttl_t2

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import java.util.Locale

class GradeListActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_grade_list)

        // 1. Dữ liệu 5 sinh viên
        val students = listOf(
            GradeStudent("Nguyễn Văn An", 9.0),
            GradeStudent("Trần Thị Bình", 7.2),
            GradeStudent("Lê Minh Chi", null),
            GradeStudent("Phạm Quốc Dũng", 4.5),
            GradeStudent("Võ Thanh Em", 5.8)
        )

        // 2. Kết nối các thành phần XML
        val txtAverage = findViewById<TextView>(R.id.txtAverage)
        val txtExcellent = findViewById<TextView>(R.id.txtExcellent)
        val txtMissing = findViewById<TextView>(R.id.txtMissing)
        val txtHighest = findViewById<TextView>(R.id.txtHighest)
        val txtListTitle = findViewById<TextView>(R.id.txtListTitle)
        val container = findViewById<LinearLayout>(R.id.gradeContainer)

        // 3. Thống kê bằng vòng lặp for + if
        var totalScore = 0.0
        var scoredCount = 0
        var excellentCount = 0
        var missingCount = 0
        var highestScore: Double? = null

        for (student in students) {

            val score = student.score

            if (score == null) {
                missingCount++
            } else {
                totalScore += score
                scoredCount++

                if (score >= 8.0 && score <= 10.0) {
                    excellentCount++
                }

                if (highestScore == null || score > highestScore) {
                    highestScore = score
                }
            }
        }

        // 4. Tính điểm trung bình
        val average = if (scoredCount > 0) {
            totalScore / scoredCount
        } else {
            0.0
        }

        // 5. Hiển thị khung thống kê
        txtAverage.text = String.format(
            Locale.US, "%.2f", average
        )

        txtExcellent.text = excellentCount.toString()
        txtMissing.text = missingCount.toString()

        txtHighest.text = if (highestScore != null) {
            String.format(Locale.US, "%.1f", highestScore)
        } else {
            "—"
        }

        txtListTitle.text =
            "DANH SÁCH · ${students.size} SINH VIÊN"

        // 6. Dùng for tạo từng thẻ sinh viên
        for (student in students) {

            val card = LinearLayout(this)
            card.orientation = LinearLayout.HORIZONTAL
            card.gravity = Gravity.CENTER_VERTICAL

            card.setPadding(
                dp(14), dp(12), dp(14), dp(12)
            )

            card.setBackgroundResource(R.drawable.student_card)

            val params = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            params.bottomMargin = dp(8)

            val infoLayout = LinearLayout(this)
            infoLayout.orientation = LinearLayout.VERTICAL

            val infoParams = LinearLayout.LayoutParams(
                0,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                1f
            )

            // Tên sinh viên
            val txtName = TextView(this)
            txtName.text = student.name
            txtName.textSize = 15f
            txtName.setTextColor(Color.rgb(30, 35, 45))
            txtName.setTypeface(null, Typeface.BOLD)
            infoLayout.addView(txtName)

            // Xếp loại
            val txtGrade = TextView(this)
            txtGrade.text = classify(student.score)
            txtGrade.textSize = 12f

            txtGrade.setTextColor(
                when (txtGrade.text.toString()) {
                    "Giỏi" -> Color.rgb(52, 128, 77)
                    "Khá" -> Color.rgb(54, 103, 171)
                    "Trung bình" -> Color.rgb(171, 122, 55)
                    "Yếu" -> Color.rgb(187, 85, 73)
                    else -> Color.GRAY
                }
            )

            infoLayout.addView(txtGrade)
            card.addView(infoLayout, infoParams)

            // Điểm sinh viên
            val txtScore = TextView(this)

            // Nullable: null sẽ hiển thị dấu —
            txtScore.text = student.score?.let {
                String.format(Locale.US, "%.1f", it)
            } ?: "—"

            txtScore.textSize = 20f
            txtScore.setTypeface(null, Typeface.BOLD)
            txtScore.setTextColor(Color.rgb(30, 35, 45))

            card.addView(txtScore)
            container.addView(card, params)
        }
    }

    private fun classify(score: Double?): String {

        if (score == null) {
            return "Chưa có điểm"
        }

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

    private fun dp(value: Int): Int {
        return (value * resources.displayMetrics.density).toInt()
    }
}