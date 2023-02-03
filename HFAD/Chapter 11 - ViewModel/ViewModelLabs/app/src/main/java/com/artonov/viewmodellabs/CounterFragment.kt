package com.artonov.viewmodellabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.artonov.viewmodellabs.databinding.FragmentCounterBinding
import com.artonov.viewmodellabs.viewmodel.CounterViewModel

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
        updateScreen()

        binding.btnCount.setOnClickListener() {
            viewModel.incrementNumber()
            updateScreen()
        }

        binding.btnSend.setOnClickListener() {
            val action =
                CounterFragmentDirections.actionCounterFragmentToResultFragment(viewModel.number)
            view.findNavController().navigate(action)
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun updateScreen() {
        binding.tvCounter.text = viewModel.number.toString()
    }

}