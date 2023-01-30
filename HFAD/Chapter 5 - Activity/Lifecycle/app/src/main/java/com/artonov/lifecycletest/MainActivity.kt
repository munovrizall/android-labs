package com.artonov.lifecycletest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.artonov.lifecycletest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textview.text = "on create"
    }


    override fun onStart() {
        super.onStart()
        binding.textview.text = "on start"

    }
    override fun onResume() {
        super.onResume()
        binding.textview.text = "on resume"
    }

    override fun onRestart() {
        super.onRestart()
        binding.textview.text = "on restart"
    }
}