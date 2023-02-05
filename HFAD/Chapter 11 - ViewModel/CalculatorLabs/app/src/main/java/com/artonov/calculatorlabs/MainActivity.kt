package com.artonov.calculatorlabs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.artonov.calculatorlabs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

//    var angka1 = 0
//    var angka2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.tvHasil.text = viewModel.result.toString()

        binding.btnCalculate.setOnClickListener() {
            var angka1 = binding.etAngka1.text.toString().toInt()
            var angka2 = binding.etAngka2.text.toString().toInt()
            viewModel.result = angka1 * angka2

            binding.tvHasil.text = viewModel.result.toString()
        }
    }
}