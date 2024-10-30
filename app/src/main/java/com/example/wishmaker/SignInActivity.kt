package com.example.wishmaker

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        // Inisialisasi EditText
        emailEditText = findViewById(R.id.et_email)
        passwordEditText = findViewById(R.id.et_password)

        // Tetapkan click listener untuk tombol "Sign In"
        findViewById<View>(R.id.btn_signin).setOnClickListener {
            loginUser()
        }
    }

    // Fungsi untuk memvalidasi login
    private fun loginUser() {
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        // Ambil data yang tersimpan di SharedPreferences
        val sharedPreferences = getSharedPreferences("USER_DATA", Context.MODE_PRIVATE)
        val savedEmail = sharedPreferences.getString("EMAIL", "")
        val savedPassword = sharedPreferences.getString("PASSWORD", "")

        // Validasi email dan password
        if (email == savedEmail && password == savedPassword) {
            Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()
            navigateToChooseTemplate()
        } else {
            Toast.makeText(this, "Email atau Password salah!", Toast.LENGTH_SHORT).show()
        }
    }

    // Fungsi untuk berpindah ke ChooseTemplateActivity
    private fun navigateToChooseTemplate() {
        val intent = Intent(this@SignInActivity, ChooseTemplateActivity::class.java)
        startActivity(intent)
        finish()
    }
}