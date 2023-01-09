package mx.mauriciogs.consumiendoapi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import mx.mauriciogs.consumiendoapi.data.model.Characters
import mx.mauriciogs.consumiendoapi.databinding.FragmentReceiverBinding

class ReceiverFragment : Fragment() {

    private var _binding: FragmentReceiverBinding? = null
    private val binding get() = _binding!!

    private lateinit var characters: mx.mauriciogs.consumiendoapi.domain.model.Characters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parentFragmentManager.setFragmentResultListener(
            "requestCharacterResult",
            this
        ) { requestKey, bundle ->
            when(requestKey) {
                "requestCharacterResult" -> {
                    val name = bundle.getString("name", "")
                    val gender = bundle.getString("gender")
                    val specie = bundle.getString("specie")
                    val state = bundle.getString("state")

                    if (name != null && gender != null && specie != null && state != null){
                        characters = mx.mauriciogs.consumiendoapi.domain.model.Characters(1, name, gender, specie, state, "")
                    }
                    setUIChar()
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentReceiverBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setUIChar() {
        with(binding){
            textView.text = characters.name
            textView2.text = characters.gender
            textView3.text = characters.specie
            textView4.text = characters.state
        }
    }

}