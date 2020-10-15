package com.example.munmuney.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.munmuney.databinding.ActivityMuneyBinding

class MuneyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMuneyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMuneyBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}