package com.artonov.navigationlabs.calculate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.artonov.navigationlabs.databinding.FragmentOutputBinding

/**
 * A simple [Fragment] subclass.
 * Use the [OutputFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OutputFragment : Fragment() {

    private var _binding: FragmentOutputBinding? = null
    private val binding get() = _binding!!
    private val args : OutputFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOutputBinding.inflate(inflater, container, false)
        val view = binding.root
        val panjang = args.panjang
        val lebar = args.lebar
        val tinggi = args.tinggi
        val result = panjang * lebar * tinggi
        binding.tvPanjang.text = result.toString()


        return view
    }
}