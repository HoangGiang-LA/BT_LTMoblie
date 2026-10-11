package com.example.bttl_t2_03

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Kết nối giao diện XML
        setContentView(R.layout.activity_main)

        // 1. TẠO DANH SÁCH 5 SINH VIÊN
        val students = listOf(
            Student(
                "Nguyễn Văn An",
                "an@sv.edu.vn",
                "0901 234 567"
            ),

            Student(
                "Trần Thị Bình",
                null,
                "0912 888 999"
            ),

            Student(
                "Lê Minh Chi",
                "chi@sv.edu.vn",
                null
            ),

            Student(
                "Phạm Quốc Dũng",
                null,
                null
            ),

            Student(
                "Võ Thanh Em",
                "em@sv.edu.vn",
                "0933 111 222"
            )
        )

        // 2. KẾT NỐI CÁC THÀNH PHẦN XML
        val studentContainer =
            findViewById<LinearLayout>(R.id.studentContainer)

        val txtTotal =
            findViewById<TextView>(R.id.txtTotal)

        val txtMissingEmail =
            findViewById<TextView>(R.id.txtMissingEmail)

        // 3. DÙNG FOR TẠO THẺ SINH VIÊN
        for (student in students) {

            // Khung chứa thông tin sinh viên
            val card = LinearLayout(this)

            card.orientation = LinearLayout.VERTICAL

            card.setPadding(
                dp(14),
                dp(12),
                dp(14),
                dp(12)
            )

            card.setBackgroundResource(
                R.drawable.student_card
            )

            val cardParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            cardParams.bottomMargin = dp(10)

            // HIỂN THỊ TÊN
            val txtName = TextView(this)

            txtName.text = student.name
            txtName.textSize = 16f
            txtName.setTextColor(Color.rgb(30, 35, 45))
            txtName.setTypeface(null, Typeface.BOLD)

            card.addView(txtName)

            // HIỂN THỊ EMAIL - NULLABLE
            val txtEmail = TextView(this)

            val emailText =
                student.email ?: "Chưa cập nhật"

            txtEmail.text = "Email: $emailText"
            txtEmail.textSize = 13f

            txtEmail.setTextColor(
                if (student.email == null) {
                    Color.rgb(190, 75, 64)
                } else {
                    Color.DKGRAY
                }
            )

            card.addView(txtEmail)

            // HIỂN THỊ SỐ ĐIỆN THOẠI - NULLABLE
            val txtPhone = TextView(this)

            val phoneText =
                student.phone ?: "Chưa cập nhật"

            txtPhone.text = "SĐT: $phoneText"
            txtPhone.textSize = 13f

            txtPhone.setTextColor(
                if (student.phone == null) {
                    Color.rgb(190, 75, 64)
                } else {
                    Color.DKGRAY
                }
            )

            card.addView(txtPhone)

            // Thêm thẻ vào màn hình
            studentContainer.addView(card, cardParams)
        }

        // 4. DÙNG FOR ĐẾM SINH VIÊN THIẾU EMAIL
        var missingEmailCount = 0

        for (student in students) {
            if (student.email == null) {
                missingEmailCount++
            }
        }

        // 5. HIỂN THỊ THỐNG KÊ
        txtTotal.text =
            "Tổng: ${students.size} sinh viên"

        txtMissingEmail.text =
            "Thiếu email: $missingEmailCount"
    }

    // Hàm chuyển dp sang pixel
    private fun dp(value: Int): Int {
        return (value * resources.displayMetrics.density).toInt()
    }
}