package com.artonov.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.constraintlayout.motion.widget.TransitionBuilder.validate
import androidx.lifecycle.ViewModelProvider
import com.artonov.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var binding: ActivityMainBinding
    private var isAnyError = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.btnPlus.setOnClickListener() {
            viewModel.peopleCount++
            binding.etPeople.setText(viewModel.peopleCount.toString())
        }

        binding.btnMinus.setOnClickListener() {
            viewModel.peopleCount--
            binding.etPeople.setText(viewModel.peopleCount.toString())
        }
        binding.etPeople.setText(viewModel.peopleCount.toString())

        binding.radio5.setChecked(true)

        updateScreen()

        binding.btnCalculate.setOnClickListener() {
            validate()
            if (!isAnyError) {
                viewModel.bill = Integer.parseInt(binding.etBill.text.toString())
                var tip = viewModel.bill * viewModel.tipPercent / 100
                viewModel.billTotal = viewModel.bill + tip
                viewModel.billPeople = viewModel.billTotal / viewModel.peopleCount
                updateScreen()
            }
        }
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.getId()) {
                R.id.radio5 ->
                    if (checked) {
                        viewModel.tipPercent = 5
                    }
                R.id.radio10 ->
                    if (checked) {
                        viewModel.tipPercent = 10
                    }
                R.id.radio15 ->
                    if (checked) {
                        viewModel.tipPercent = 15
                    }
                R.id.radio20 ->
                    if (checked) {
                        viewModel.tipPercent = 20
                    }
            }
        }
    }

    fun validate() {
        if (TextUtils.isEmpty(binding.etBill.text)) {
            binding.etBill.setError("Field must be filled")
            isAnyError = true
        } else {
            binding.etBill.setError(null)
            isAnyError = false
        }
    }

    fun updateScreen() {
//        textView.text = "%,d".format(100000)
//        binding.tvTotalBill.text = "Total bill is: ${viewModel.billTotal}"
        binding.tvTotalBill.text = "Total bill is: %,d".format(viewModel.billTotal)
        binding.tvPersonBill.text = "Every Person is: %,d".format(viewModel.billPeople)
    }


}