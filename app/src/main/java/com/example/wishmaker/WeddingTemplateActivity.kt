package com.example.wishmaker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wishmaker.databinding.ActivityWeddingTemplateBinding

class WeddingTemplateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeddingTemplateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeddingTemplateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari intent dan set ke TextView
        binding.tvRecepient.text = intent.getStringExtra("RECEPIENT")
        binding.tvMessage.text = intent.getStringExtra("MESSAGE")
        binding.closing.text = intent.getStringExtra("CLOSING")
        binding.tvSender.text = intent.getStringExtra("SENDER")
    }
}
