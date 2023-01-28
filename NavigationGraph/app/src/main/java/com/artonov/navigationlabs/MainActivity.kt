package com.artonov.navigationlabs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.artonov.navigationlabs.calculate.HomeActivity
import com.artonov.navigationlabs.databinding.ActivityMainBinding
import com.artonov.navigationlabs.login.LoginActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGetStarted.setOnClickListener() {
            val intent = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener() {
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}