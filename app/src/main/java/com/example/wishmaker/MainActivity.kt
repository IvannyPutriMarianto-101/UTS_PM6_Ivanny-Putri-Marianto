package com.example.wishmaker

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Temukan tombol dan tetapkan OnClickListener
        findViewById<View>(R.id.btn_start).setOnClickListener { // Membuat intent untuk memulai SignUpActivity
            val intent = Intent(
                this@MainActivity,
                SignUpActivity::class.java
            )
            startActivity(intent)
        }
    }
}