package com.artonov.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.constraintlayout.motion.widget.TransitionBuilder.validate
import com.artonov.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var tipPercent = 5
    private var peopleCount = 1
    private var isAnyError = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPlus.setOnClickListener() {
           peopleCount++
            binding.etPeople.setText(peopleCount.toString())
        }

        binding.btnMinus.setOnClickListener() {
            peopleCount--
            binding.etPeople.setText(peopleCount.toString())
        }
        binding.etPeople.setText(peopleCount.toString())

        binding.radio5.setChecked(true)

        binding.btnCalculate.setOnClickListener() {
            validate()
            if (!isAnyError) {
                var bill = Integer.parseInt(binding.etBill.text.toString())
                var tip = bill * tipPercent / 100
                var billTotal = bill + tip
                var billPeople = billTotal / peopleCount

                binding.tvTotalBill.text = "Total bill is: $billTotal"
                binding.tvPersonBill.text = "Every Person is: $billPeople"
            }
        }

    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.getId()) {
                R.id.radio5 ->
                    if (checked) {
                       tipPercent = 5
                    }
                R.id.radio10 ->
                    if (checked) {
                        tipPercent = 10
                    }
                R.id.radio15 ->
                    if (checked) {
                        tipPercent = 15
                    }
                R.id.radio20 ->
                    if (checked) {
                        tipPercent = 20
                    }
            }
        }
    }

    fun validate() {
        if (TextUtils.isEmpty(binding.etBill.text)) {
            binding.etBill.setError("Field must be filled")
            isAnyError = true
        }else{
            binding.etBill.setError(null)
            isAnyError = false
        }
    }
}