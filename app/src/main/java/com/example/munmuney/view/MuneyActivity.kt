package com.example.munmuney.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.munmuney.R
import com.example.munmuney.databinding.ActivityMuneyBinding

class MuneyActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMuneyBinding
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMuneyBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setUpBottomNav()
  }

  private fun setUpBottomNav() {
    val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_host) as NavHostFragment
    NavigationUI.setupWithNavController(binding.bnvNavigation, navHostFragment.navController)
  }
}