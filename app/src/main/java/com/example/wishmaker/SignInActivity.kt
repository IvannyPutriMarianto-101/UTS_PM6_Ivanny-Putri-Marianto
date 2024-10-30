package com.example.wishmaker

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        // Tetapkan click listener untuk tombol "Sign In"
        findViewById<View>(R.id.btn_signin).setOnClickListener {
            // Memulai ChooseTemplateActivity
            val intent = Intent(
                this@SignInActivity,
                ChooseTemplateActivity::class.java
            )
            startActivity(intent)
            finish()
        }
    }
}