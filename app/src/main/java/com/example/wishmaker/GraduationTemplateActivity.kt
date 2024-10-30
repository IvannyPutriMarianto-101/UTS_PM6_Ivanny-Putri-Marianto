package com.example.wishmaker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wishmaker.databinding.ActivityGraduationTemplateBinding

class GraduationTemplateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGraduationTemplateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGraduationTemplateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari intent dan set ke TextView
        binding.tvRecepient.text = intent.getStringExtra("RECEPIENT")
        binding.tvMessage.text = intent.getStringExtra("MESSAGE")
        binding.closing.text = intent.getStringExtra("CLOSING")
        binding.tvSender.text = intent.getStringExtra("SENDER")

    }
}
