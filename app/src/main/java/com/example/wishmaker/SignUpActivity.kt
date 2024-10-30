package com.example.wishmaker

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Inisialisasi EditText
        emailEditText = findViewById(R.id.et_email)
        passwordEditText = findViewById(R.id.et_password)
        confirmPasswordEditText = findViewById(R.id.et_comfirm_password)

        // Listener klik untuk TextView "Sudah punya akun?"
        findViewById<View>(R.id.signin).setOnClickListener {
            navigateToSignIn()
        }

        // Listener untuk tombol Sign Up
        findViewById<View>(R.id.btn_signup).setOnClickListener {
            registerUser()
        }
    }

    // Fungsi untuk mencocokkan password dan confirm password, lalu simpan data
    private fun registerUser() {
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()
        val confirmPassword = confirmPasswordEditText.text.toString().trim()

        // Validasi email dan password
        if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Semua kolom harus diisi!", Toast.LENGTH_SHORT).show()
            return
        }

        if (password != confirmPassword) {
            Toast.makeText(this, "Password dan Confirm Password tidak sama!", Toast.LENGTH_SHORT).show()
            return
        }

        // Simpan email dan password menggunakan SharedPreferences
        val sharedPreferences = getSharedPreferences("USER_DATA", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("EMAIL", email)
        editor.putString("PASSWORD", password)
        editor.apply()

        Toast.makeText(this, "Pendaftaran berhasil! Silakan masuk.", Toast.LENGTH_SHORT).show()

        navigateToSignIn()
    }

    // Fungsi untuk berpindah ke SignInActivity
    private fun navigateToSignIn() {
        val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
        startActivity(intent)
        finish()
    }
}
