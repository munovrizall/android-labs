package com.artonov.navigationlabs.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.artonov.navigationlabs.R
import com.artonov.navigationlabs.calculate.OutputFragmentArgs
import com.artonov.navigationlabs.databinding.FragmentLoginBinding
import com.artonov.navigationlabs.databinding.FragmentUserBinding
import kotlinx.android.synthetic.main.fragment_user.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UserFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserFragment : Fragment() {
    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!
    private val args : UserFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        val view = binding.root
        val username = args.username
        val password = args.password

        binding.tvUsername.text = username + password
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}