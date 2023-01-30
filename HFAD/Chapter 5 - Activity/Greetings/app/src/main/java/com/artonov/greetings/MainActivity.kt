package com.artonov.greetings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var message: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.name)
        val update = findViewById<Button>(R.id.update_button)
        message = findViewById<TextView>(R.id.greeting)

        message.text = savedInstanceState?.getCharSequence("")

        update.setOnClickListener(){
            message.text = "Hello ${name.text}"
        }


    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.putCharSequence("", message.text)
        super.onSaveInstanceState(savedInstanceState)
    }
}