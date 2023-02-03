package com.artonov.viewmodellabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.artonov.viewmodellabs.databinding.FragmentResultBinding
import com.artonov.viewmodellabs.viewmodel.ResultViewModel
import com.artonov.viewmodellabs.viewmodel.ResultViewModelFactory

class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    lateinit var viewModel: ResultViewModel
    lateinit var viewModelFactory: ResultViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        val view = binding.root
//        val result = com.artonov.viewmodellabs.ResultFragmentArgs.fromBundle(
//            requireArguments()
//        ).countNumber

        val countNumber = ResultFragmentArgs.fromBundle(requireArguments()).countNumber
        viewModelFactory = ResultViewModelFactory(countNumber)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(ResultViewModel::class.java)
        
        binding.tvNumber.text = countNumber.toString()

        binding.btnBack.setOnClickListener() {
            val action =
                com.artonov.viewmodellabs.ResultFragmentDirections.actionResultFragmentToCounterFragment()
            view.findNavController().navigate(action)
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}