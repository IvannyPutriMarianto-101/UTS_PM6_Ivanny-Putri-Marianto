package com.example.wishmaker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class FormInputActivity : AppCompatActivity() {

    private lateinit var etRecepient: EditText
    private lateinit var etMessage: EditText
    private lateinit var etClosing: EditText
    private lateinit var etSender: EditText
    private lateinit var btnSubmit: Button
    private var templateType: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_input)

        // Ambil tipe template dari intent
        templateType = intent.getStringExtra("TEMPLATE_TYPE")

        // Inisialisasi input fields
        etRecepient = findViewById(R.id.et_recepient)
        etMessage = findViewById(R.id.et_message)
        etClosing = findViewById(R.id.et_closing)
        etSender = findViewById(R.id.et_sender)
        btnSubmit = findViewById(R.id.btn_result)

        // Set listener untuk tombol submit
        btnSubmit.setOnClickListener { openTemplateActivity() }
    }

    private fun openTemplateActivity() {
        // Intent menuju template activity berdasarkan tipe template
        val intent = when (templateType) {
            "birthday" -> Intent(this, BirthdayTemplateActivity::class.java)
            "christmas" -> Intent(this, ChristmasTemplateActivity::class.java)
            "graduation" -> Intent(this, GraduationTemplateActivity::class.java)
            "wedding" -> Intent(this, WeddingTemplateActivity::class.java)
            else -> throw IllegalStateException("Unexpected template type: $templateType")
        }

        // Kirim data input ke template activity
        intent.putExtra("RECEPIENT", etRecepient.text.toString())
        intent.putExtra("MESSAGE", etMessage.text.toString())
        intent.putExtra("CLOSING", etClosing.text.toString())
        intent.putExtra("SENDER", etSender.text.toString())

        startActivity(intent)
    }
}
