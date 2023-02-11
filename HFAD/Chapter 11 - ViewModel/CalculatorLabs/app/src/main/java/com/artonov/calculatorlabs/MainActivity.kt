package com.artonov.calculatorlabs

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.artonov.calculatorlabs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
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

        ArrayAdapter.createFromResource(
            this,
            R.array.operations_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerOperations.adapter = adapter
        }

        binding.spinnerOperations.onItemSelectedListener = this

        binding.btnCalculate.setOnClickListener() {
            var angka1 = binding.etAngka1.text.toString().toInt()
            var angka2 = binding.etAngka2.text.toString().toInt()
            viewModel.result = angka1 * angka2

            binding.tvHasil.text = viewModel.result.toString()
            showToast(message = "Halo")
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        when (view?.id) {
            0 -> showToast(message = "Plus selected")
            1 -> showToast(message = "Minus selected")

        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        showToast(message = "Nothing selected")
    }
    private fun showToast(context: Context = applicationContext, message: String, duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(context, message, duration).show()
    }
}