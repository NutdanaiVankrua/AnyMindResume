package com.example.anymindresume

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.anymindresume.databinding.ActivityAnyMindResumeBinding

class AnyMindResumeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnyMindResumeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnyMindResumeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}