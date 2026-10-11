package com.example.btvn_t2_01

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import java.util.Locale

class MainActivity : ComponentActivity() {

    // Phép tính đang được chọn
    private var selectedOperation: String? = null

    // Các thành phần giao diện
    private lateinit var edtNumber1: EditText
    private lateinit var edtNumber2: EditText
    private lateinit var txtResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Hiển thị giao diện XML
        setContentView(R.layout.activity_main)

        // Kết nối các thành phần
        edtNumber1 = findViewById(R.id.edtNumber1)
        edtNumber2 = findViewById(R.id.edtNumber2)
        txtResult = findViewById(R.id.txtResult)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)

        // Nhập sẵn 4 và 4 giống hình mẫu
        edtNumber1.setText("4")
        edtNumber2.setText("4")

        // Nhấn nút cộng
        btnAdd.setOnClickListener {
            selectedOperation = "+"
            calculate()
        }

        // Nhấn nút trừ
        btnSubtract.setOnClickListener {
            selectedOperation = "-"
            calculate()
        }

        // Nhấn nút nhân
        btnMultiply.setOnClickListener {
            selectedOperation = "*"
            calculate()
        }

        // Nhấn nút chia
        btnDivide.setOnClickListener {
            selectedOperation = "/"
            calculate()
        }

        // Tự tính lại khi người dùng sửa số
        val watcher = object : TextWatcher {

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {}

            override fun onTextChanged(
                s: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                calculate()
            }

            override fun afterTextChanged(s: Editable?) {}
        }

        edtNumber1.addTextChangedListener(watcher)
        edtNumber2.addTextChangedListener(watcher)
    }

    // HÀM TÍNH TOÁN
    private fun calculate() {

        val number1 = edtNumber1.text.toString().toDoubleOrNull()
        val number2 = edtNumber2.text.toString().toDoubleOrNull()

        // Kiểm tra ô trống hoặc nhập sai
        if (number1 == null || number2 == null) {
            txtResult.text = "Kết quả: Vui lòng nhập đủ hai số"
            txtResult.setTextColor(Color.RED)
            return
        }

        // Giới hạn trong khoảng -99 đến 99
        if (number1 !in -99.0..99.0 ||
            number2 !in -99.0..99.0) {

            txtResult.text = "Kết quả: Chỉ nhập số từ -99 đến 99"
            txtResult.setTextColor(Color.RED)
            return
        }

        // Chưa chọn phép tính
        if (selectedOperation == null) {
            txtResult.text = "Kết quả:"
            txtResult.setTextColor(Color.BLACK)
            return
        }

        // Không cho phép chia cho 0
        if (selectedOperation == "/" && number2 == 0.0) {
            txtResult.text = "Kết quả: Không thể chia cho 0"
            txtResult.setTextColor(Color.RED)
            return
        }

        // Thực hiện phép tính
        val result = when (selectedOperation) {
            "+" -> number1 + number2
            "-" -> number1 - number2
            "*" -> number1 * number2
            "/" -> number1 / number2
            else -> return
        }

        // Hiển thị kết quả tối đa 6 chữ số thập phân
        val formattedResult = String.format(
            Locale.US,
            "%.6f",
            result
        ).trimEnd('0').trimEnd('.')

        txtResult.text = "Kết quả: $formattedResult"
        txtResult.setTextColor(Color.BLACK)
    }
}