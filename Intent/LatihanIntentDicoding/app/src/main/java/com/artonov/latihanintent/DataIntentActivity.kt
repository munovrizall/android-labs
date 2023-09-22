package com.artonov.latihanintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.artonov.latihanintent.databinding.ActivityDataIntentBinding

class DataIntentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDataIntentBinding

    companion object {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDataIntentBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)

        binding.tvData.text = " my name is $name, my age is $age"
    }
}