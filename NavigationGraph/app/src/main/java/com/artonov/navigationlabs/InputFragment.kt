package com.artonov.navigationlabs

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
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
import kotlinx.android.synthetic.main.fragment_input.*

class InputFragment : Fragment(R.layout.fragment_input) {

    private var _binding: FragmentInputBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentInputBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnCalculate.setOnClickListener() {
            val panjang = binding.etPanjang.text
            val lebar = binding.etLebar.text
            val tinggi = binding.etTinggi.text

            var isAnyError = false
            if (TextUtils.isEmpty(binding.etPanjang.text)) {
                binding.etPanjang.setError("Field must be filled")
                isAnyError = true
            }else{
                binding.etPanjang.setError(null)
            }

            if (TextUtils.isEmpty(binding.etLebar.text)) {
                binding.etLebar.setError("Field must be filled")
                isAnyError = true
            }else{
                binding.etLebar.setError(null)
            }

            if (TextUtils.isEmpty(binding.etTinggi.text)) {
                binding.etTinggi.setError("Field must be filled")
                isAnyError = true
            }else{
                binding.etTinggi.setError(null)
            }

            if(!isAnyError){
                val action = InputFragmentDirections.actionInputFragmentToOutputFragment(
                    panjang.toString().toInt(),
                    lebar.toString().toInt(),
                    tinggi.toString().toInt()
                )

                findNavController().navigate(
                    action
                )
            }
        }


        return view
    }

}