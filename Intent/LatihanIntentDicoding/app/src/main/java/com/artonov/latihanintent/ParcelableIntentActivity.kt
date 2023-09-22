package com.artonov.latihanintent

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.artonov.latihanintent.databinding.ActivityParcelableIntentBinding

class ParcelableIntentActivity : AppCompatActivity() {
    lateinit var binding: ActivityParcelableIntentBinding

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityParcelableIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val person = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra<Person>(EXTRA_PERSON, Person::class.java)
        } else {
            intent.getParcelableExtra<Person>(EXTRA_PERSON)
        }

        if (person != null) {
            binding.tvParcelable.text = "Name : ${person.name.toString()},\nEmail : ${person.email},\nAge : ${person.age},\nLocation : ${person.city}"
        }
    }
}