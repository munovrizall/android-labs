package com.artonov.secretmessage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController

class MessageFragment : Fragment(R.layout.fragment_message) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_message, container, false)
        val nextButton = view.findViewById<Button>(R.id.btnNext)
        val messageEdit = view.findViewById<EditText>(R.id.etMessage)

        nextButton.setOnClickListener() {
            val message = messageEdit.text.toString()
            val action = MessageFragmentDirections
                .actionMessageFragmentToEncryptedFragment(message)

            view.findNavController()
                .navigate(action)
        }
        return view
    }
}