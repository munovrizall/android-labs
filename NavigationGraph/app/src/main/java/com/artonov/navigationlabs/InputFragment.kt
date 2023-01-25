package com.artonov.navigationlabs

import android.content.Intent
import android.os.Bundle
import android.util.Log.v
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.artonov.navigationlabs.databinding.FragmentInputBinding

class InputFragment : Fragment(R.layout.fragment_input) {

    private var _binding: FragmentInputBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentInputBinding.inflate(inflater, container, false)
        val view = binding.root
//        val view = inflater.inflate(R.layout.fragment_input, container, false)
//        val btnCalculate = view.findViewById<Button>(R.id.btnCalculate)
        binding.btnCalculate.setOnClickListener() {
            val panjang = binding.etPanjang.text.toString().toInt()
            val lebar = binding.etLebar.text.toString().toInt()
            val tinggi = binding.etTinggi.text.toString().toInt()

            val action = InputFragmentDirections.actionInputFragmentToOutputFragment(panjang, lebar, tinggi)

            findNavController().navigate(
                action
            )

//            val action = InputFragmentDirections.actionInputFragmentToOutputFragment()
//            view.findNavController().navigate(action)
////            view.findNavController().navigate(R.id.action_inputFragment_to_outputFragment)
        }


        return view
    }

}