package br.com.doreadev.estudonavigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.doreadev.estudonavigation.R
import br.com.doreadev.estudonavigation.databinding.FragmentAddressBinding
import br.com.doreadev.estudonavigation.extensions.text
import br.com.doreadev.estudonavigation.models.PersonModel

class AddressFragment : Fragment() {

    private var _binding: FragmentAddressBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, group: ViewGroup?, saved: Bundle?): View {
        // Inflate the layout for this fragment
        _binding = FragmentAddressBinding.inflate(inflater,group,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mbtnNextId.setOnClickListener {
            val person = PersonModel(
                street = binding.tilLayoutStreetId.text,
                number = binding.tilLayoutNumberId.text.toInt()
            )

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}