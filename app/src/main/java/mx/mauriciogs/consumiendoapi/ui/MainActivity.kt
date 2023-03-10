package mx.mauriciogs.consumiendoapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import mx.mauriciogs.consumiendoapi.databinding.ActivityMainBinding
import mx.mauriciogs.consumiendoapi.domain.model.Characters

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var initialFragment: InitialFragment
    private lateinit var charactersFragment: CharactersFragment
    var numPag = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setInitialFrag()
        mainViewModel.getAllCharacter()
        charactersFragment = CharactersFragment(mainViewModel.listChar)
    }

    private fun setInitialFrag() {
        initialFragment = InitialFragment()
        supportFragmentManager
            .beginTransaction()
            .add(binding.flFragmentContainer.id, initialFragment)
            .commit()
    }

    /*
    private fun initObservers() {
        // Observamos la variable anyCharacter del ViewModel, cuando esta cambie su valor
        // se llamarĂ¡ a setUI pasando dicho valor
        //mainViewModel.anyCharacter.observe(this) {  character ->
            //setUI(character)

        //}

        // Observamos la variable showError para mostrar en pantalla cuando falle algo al obtener los datos
        mainViewModel.showError.observe(this) { errorMessage ->
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG)
        }

        // Observar la variable creada en el viewModel que trae la lista de personajes y pasarle
        // dicha lista al Recycler View actualizando su contenido
    }
    */
    // Por ahora pintamos la UI con los datos de un personaje obtenido, algo similar se debe aplicar
    // cuando se listen los personajes, pero se utilizarĂ¡ un RecyclerView
    /*
    private fun setUI(personaje: Characters) {
        Glide.with(this@MainActivity)
            .load(personaje.image)
            .centerCrop()
            .into(binding.ivCharacter)
        binding.tvNameCharacter.text = personaje.name
        binding.tvGenderCharacter.text = personaje.gender
        binding.tvSpecieCharacter.text = personaje.specie
        binding.tvStateCharacter.text = personaje.state
    }
    */
    // Solo si se da click, se van a mostrar
    fun click(view: View){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.flFragmentContainer.id,charactersFragment).commit()
    }
}