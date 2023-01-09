package mx.mauriciogs.consumiendoapi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import mx.mauriciogs.consumiendoapi.R
import mx.mauriciogs.consumiendoapi.databinding.FragmentCharBinding
import mx.mauriciogs.consumiendoapi.domain.model.Characters

class CharactersFragment(private val listChar: ArrayList<Characters>) : Fragment() {
    private var _binding: FragmentCharBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCharBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        binding.rvChar.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvChar.adapter = CharactersAdapter(requireActivity(), this@CharactersFragment, listChar)
    }

    fun onClickItem(item: Characters) {
        Toast.makeText(requireActivity(),"Personaje: ${item.name}", Toast.LENGTH_LONG).show()

        val bundle = Bundle()
        bundle.putString("name", item.name)
        bundle.putString("gender", item.gender)
        bundle.putString("specie", item.specie)
        bundle.putString("state", item.state)

        parentFragmentManager.setFragmentResult("requestCharacterResult", bundle)

        val receiver = ReceiverFragment()
        parentFragmentManager.beginTransaction().replace(R.id.flFragmentContainer, receiver).commit()
    }

}