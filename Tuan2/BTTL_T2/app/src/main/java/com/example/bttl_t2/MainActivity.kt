package com.example.bttl_t2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(
            this,
            GradeListActivity::class.java
        )

        startActivity(intent)

        finish()
    }
}