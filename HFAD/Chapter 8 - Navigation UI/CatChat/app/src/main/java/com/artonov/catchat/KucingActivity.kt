package com.artonov.catchat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.artonov.catchat.databinding.ActivityKucingBinding
import com.artonov.catchat.databinding.ActivityMainBinding

class KucingActivity : AppCompatActivity() {

    lateinit var binding: ActivityKucingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKucingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBar)

//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
//        val navController = findNavController(R.id.app_nav)
//        val config = AppBarConfiguration(navController.graph)
//        binding.toolBar.setupWithNavController(navController, config)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.kucingActivity -> {
                val i = Intent(this@KucingActivity, MainActivity::class.java)
                startActivity(i)
                return true
            }
            R.id.helpFragment -> {
                val i = Intent(this@KucingActivity, HelpFragment::class.java)
                startActivity(i)
                return true
            }
            else -> return true
        }
    }
}