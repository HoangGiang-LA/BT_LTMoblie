package com.example.btvn_t1

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Hiển thị giao diện activity_profile.xml
        setContentView(R.layout.activity_profile)


        // Nút quay lại
        val btnBack = findViewById<TextView>(R.id.btnBack)

        btnBack.setOnClickListener {

            Toast.makeText(
                this,
                "Bạn đã nhấn nút quay lại",
                Toast.LENGTH_SHORT
            ).show()

        }


        // Nút chỉnh sửa
        val btnEdit = findViewById<TextView>(R.id.btnEdit)

        btnEdit.setOnClickListener {

            Toast.makeText(
                this,
                "Chức năng chỉnh sửa thông tin",
                Toast.LENGTH_SHORT
            ).show()

        }

    }
}