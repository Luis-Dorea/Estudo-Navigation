package br.com.doreadev.estudonavigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.Person
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.doreadev.estudonavigation.R
import br.com.doreadev.estudonavigation.databinding.FragmentPersonalDataBinding
import br.com.doreadev.estudonavigation.extensions.text
import br.com.doreadev.estudonavigation.models.PersonModel

class PersonalDataFragment : Fragment() {

    private var _binding: FragmentPersonalDataBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, group: ViewGroup?, saved: Bundle?): View {
        // Inflate the layout for this fragment
        _binding = FragmentPersonalDataBinding.inflate(inflater,group,false)
        return binding.root
    }

    //É onde eu vou fazer o binding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mbtnNextId.setOnClickListener {
            val model = PersonModel(
                name = binding.tilLayoutNameId.text,
                age = binding.tilLayoutAgeId.text.toInt()
            )

            val directions = PersonalDataFragmentDirections.goToAddressFragment(model)
            findNavController().navigate(directions)
            //Mandar os dados para outro fragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}