package com.example.wishmaker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class ChooseTemplateActivity : AppCompatActivity() {

    private lateinit var cardBirthday: CardView
    private lateinit var cardChristmas: CardView
    private lateinit var cardGraduation: CardView
    private lateinit var cardWedding: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_template)

        // Inisialisasi tombol Customize
        val btnCustomizeBirthday: Button = findViewById(R.id.btn_card_birthday)
        val btnCustomizeChristmas: Button = findViewById(R.id.btn_card_christmas)
        val btnCustomizeGraduation: Button = findViewById(R.id.btn_card_graduation)
        val btnCustomizeWedding: Button = findViewById(R.id.btn_card_wedding)

        // Set click listeners untuk tombol Customize
        btnCustomizeBirthday.setOnClickListener { openFormActivity("birthday") }
        btnCustomizeChristmas.setOnClickListener { openFormActivity("christmas") }
        btnCustomizeGraduation.setOnClickListener { openFormActivity("graduation") }
        btnCustomizeWedding.setOnClickListener { openFormActivity("wedding") }
    }

    private fun openFormActivity(templateType: String) {
        // Pindah ke FormInputActivity dengan template type
        val intent = Intent(this, FormInputActivity::class.java)
        intent.putExtra("TEMPLATE_TYPE", templateType)
        startActivity(intent)
    }
}
