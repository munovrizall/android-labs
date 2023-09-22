package com.artonov.latihanintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import com.artonov.latihanintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == ResultIntentActivity.RESULT_CODE && result.data != null) {
            val selectedValue = result.data?.getIntExtra(ResultIntentActivity.EXTRA_SELECTED_VALUE, 0)
            binding.tvResultIntent.text = "Selected value = $selectedValue"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMoveActivity.setOnClickListener(this)
        binding.btnMoveDataActivity.setOnClickListener(this)
        binding.btnMoveParcelActivity.setOnClickListener(this)
        binding.btnMoveResultActivity.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            binding.btnMoveActivity.id -> {
                val intent = Intent(this@MainActivity, ExplicitIntentActivity::class.java)
                startActivity(intent)
            }

            binding.btnMoveDataActivity.id -> {
                val intent = Intent(this@MainActivity, DataIntentActivity::class.java)
                intent.putExtra(DataIntentActivity.EXTRA_NAME, "Jale")
                intent.putExtra(DataIntentActivity.EXTRA_AGE, 21)
                startActivity(intent)
            }

            binding.btnMoveParcelActivity.id -> {
                val person = Person("Jale", 21, "jale@email", "Jakarta")
                val intent = Intent(this@MainActivity, ParcelableIntentActivity::class.java)
                intent.putExtra(ParcelableIntentActivity.EXTRA_PERSON, person)
                startActivity(intent)
            }

            binding.btnMoveResultActivity.id -> {
                val intent = Intent(this@MainActivity, ResultIntentActivity::class.java)
                resultLauncher.launch(intent)
            }
        }
    }
}