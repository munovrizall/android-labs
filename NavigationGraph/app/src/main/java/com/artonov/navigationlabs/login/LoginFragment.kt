package com.artonov.navigationlabs.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.artonov.navigationlabs.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnSubmitLogin.setOnClickListener() {
            val username = binding.etUsername.text
            val password = binding.etPassword.text


            val action = LoginFragmentDirections.actionLoginFragmentToUserFragment(
                username.toString(), password.toString()
            )

            findNavController().navigate(
                action
            )
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}