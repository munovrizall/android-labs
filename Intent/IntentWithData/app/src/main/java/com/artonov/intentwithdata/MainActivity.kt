package com.artonov.intentwithdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.artonov.intentwithdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener() {
            val judul = binding.etJudul.text.toString()
            val isbn = binding.etIsbn.text.toString().toInt()
            val penulis = binding.etPenulis.text.toString()
            val buku = Buku(judul, isbn, penulis)

            Intent(this, SecondActivity::class.java).also {
                it.putExtra("EXTRA_BUKU", buku)
                startActivity(it)
            }
        }
    }
}