package com.artonov.latihanintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.artonov.latihanintent.databinding.ActivityResultIntentBinding

class ResultIntentActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }
    lateinit var binding: ActivityResultIntentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnChoose.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == binding.btnChoose.id) {
            if (binding.rgNumber.checkedRadioButtonId > 0) {
                var value = 0

                when (binding.rgNumber.checkedRadioButtonId) {
                    binding.rb50.id -> value = 50
                    binding.rb100.id -> value = 100
                    binding.rb150.id -> value = 150
                    binding.rb200.id -> value = 200
                }

                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }
        }
    }
}