package com.example.materialviews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.materialviews.databinding.FragmentOrderBinding
import com.google.android.material.snackbar.Snackbar

class OrderFragment : Fragment() {
    private var _binding: FragmentOrderBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        val view = binding.root
        (activity as AppCompatActivity).setSupportActionBar(binding.toolBar)


        binding.fabDone.setOnClickListener() {
            val pizzaType = binding.pizzaGroup.checkedRadioButtonId
            if (pizzaType == -1) {
                val text = "You need to choose a pizza type"
                Toast.makeText(activity, text, Toast.LENGTH_LONG).show()
            } else {
                var text = (when (pizzaType) {
                    R.id.radioDiavolo -> "Diavolo Pizza"
                    else -> "Funghi Pizza"
                } )

                text += if (binding.parmesan.isChecked) ", extra parmesan" else " "
                text += if (binding.Chilli.isChecked) ", extra chilli oil" else " "
                Snackbar.make(binding.fabDone, text, Snackbar.LENGTH_LONG).show()
            }

        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}