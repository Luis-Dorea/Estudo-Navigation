package br.com.doreadev.estudonavigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import br.com.doreadev.estudonavigation.R
import br.com.doreadev.estudonavigation.databinding.FragmentResumeBinding

class ResumeFragment : Fragment() {
    private var _binding: FragmentResumeBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<ResumeFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, group: ViewGroup?, saved: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentResumeBinding.inflate(inflater,group,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvPersonId.text = args.model.person
        binding.tvAddressId.text = args.model.address
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}