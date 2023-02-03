package com.artonov.viewmodellabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.artonov.viewmodellabs.databinding.FragmentCounterBinding
import com.artonov.viewmodellabs.databinding.FragmentResultBinding

class CounterFragment : Fragment() {

    private var _binding: FragmentCounterBinding? = null
    private val binding get() = _binding!!

    lateinit var viewModel: CounterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCounterBinding.inflate(inflater, container, false)
        val view = binding.root

        viewModel = ViewModelProvider(this).get(CounterViewModel::class.java)
        binding.tvCounter.text = viewModel.number.toString()

        binding.btnCount.setOnClickListener() {
            viewModel.incrementNumber()
            binding.tvCounter.text = viewModel.number.toString()
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}