package mx.mauriciogs.consumiendoapi.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import mx.mauriciogs.consumiendoapi.data.model.Characters
import mx.mauriciogs.consumiendoapi.databinding.CharElementBinding

class CharactersAdapter (
    private val context: Context,
    private val fragment: Fragment,
    private val arrChars: ArrayList<mx.mauriciogs.consumiendoapi.domain.model.Characters>) : RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    inner class ViewHolder(view: CharElementBinding): RecyclerView.ViewHolder(view.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CharElementBinding.inflate(LayoutInflater.from(context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = arrChars[position]

        with(holder){

        }

        holder.itemView.setOnClickListener {
            if (fragment is CharactersFragment) fragment.onClickItem(item)
        }
    }

    override fun getItemCount(): Int = arrChars.size
}