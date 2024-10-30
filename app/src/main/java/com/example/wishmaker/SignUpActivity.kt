package com.example.wishmaker

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Listener klik untuk TextView "Sudah punya akun?"
        findViewById<View>(R.id.signin).setOnClickListener {
            // Mulai SignInActivity
            navigateToSignIn()
        }

        findViewById<View>(R.id.btn_signup).setOnClickListener {
            navigateToSignIn()
        }
    }

    private fun navigateToSignIn() {
        val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
        startActivity(intent)
        finish()
    }
}
