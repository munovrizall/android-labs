package com.artonov.intentwithdata

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.artonov.intentwithdata.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buku = intent.getParcelableExtra<Buku>("EXTRA_BUKU")!!

        Log.d("test", buku.toString())
        binding.tvBuku.text = buku.toString()
    }
}