package br.com.doreadev.estudonavigation.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.doreadev.estudonavigation.databinding.FragmentAddressBinding
import br.com.doreadev.estudonavigation.extensions.text
import br.com.doreadev.estudonavigation.models.PersonModel

class AddressFragment : Fragment() {

    private var _binding: FragmentAddressBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<AddressFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, group: ViewGroup?, saved: Bundle?): View {
        // Inflate the layout for this fragment
        _binding = FragmentAddressBinding.inflate(inflater,group,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.e(TAG, "onViewCreated: ${args.model}")

        binding.mbtnNextId.setOnClickListener {
            /**A ideia seria pegar o name e o age e recuperar passando na nova instancia, mas não é
            //legal, pois teríamos duas intancias desnecessárias sendo que podemos usar o copy como
            //solução, fazendo uma cópia do objeto.
            val person = PersonModel(
                name = args.model.name,
                age = args.model.age,
                street = binding.tilLayoutStreetId.text,
                number = binding.tilLayoutNumberId.text.toInt()
            )*/

            //Fica melhor assim:
            val model = args.model.copy(
                street = binding.tilLayoutStreetId.text,
                number = binding.tilLayoutNumberId.text.toInt()
            )

            val directions = AddressFragmentDirections.goToResumeFragment(model)
            findNavController().navigate(directions)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}