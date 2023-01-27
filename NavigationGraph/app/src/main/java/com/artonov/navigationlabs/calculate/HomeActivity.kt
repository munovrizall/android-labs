package com.artonov.navigationlabs.calculate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.artonov.navigationlabs.R
import com.artonov.navigationlabs.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity(R.layout.fragment_output) {

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBar)
    }
}