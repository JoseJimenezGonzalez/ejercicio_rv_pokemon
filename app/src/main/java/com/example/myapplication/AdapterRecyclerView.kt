package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemPokemonBinding

class AdapterRecyclerView(private var listaPokemons: MutableList<Pokemon>, private val itemClickListener: OnItemClickListener): RecyclerView.Adapter<AdapterRecyclerView.ViewHolder>() {
    //onCreateViewHolder: Se llama cuando se necesita crear un nuevo ViewHolder. En este método, se
    //infla el diseño (R.layout.item_user) utilizando LayoutInflater para convertir el diseño XML en
    //una vista (View). Luego, se crea y devuelve una instancia de ViewHolder que contiene esa vista.
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterRecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return ViewHolder(view)
    }
    //onBindViewHolder: Se llama para asociar datos a una vista específica en una posición específica.
    //Aquí, se obtiene el ViewHolder correspondiente y se llama al método bind del ViewHolder, pasando
    //la Persona en la posición actual.
    override fun onBindViewHolder(holder: AdapterRecyclerView.ViewHolder, position: Int) {
        val itemPokemonActual = listaPokemons[position]

        holder.bind(itemPokemonActual)

    }
    //getItemCount: Devuelve el número total de elementos en el conjunto de datos (en este caso, la lista de usuarios).
    override fun getItemCount(): Int = listaPokemons.size
    //ViewHolder: Es una clase interna que extiende RecyclerView.ViewHolder. Su propósito es contener
    //y gestionar las vistas de un elemento individual en el RecyclerView.
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener{

        val binding = ItemPokemonBinding.bind(view)

        init {
            view.setOnClickListener(this)
        }

        fun bind(pokemon: Pokemon){
            binding.tvNombrePokemon.text = pokemon.nombrePokemon
            binding.cbCapturado.isChecked = pokemon.capturado
        }

        override fun onClick(v: View) {
            val posicion: Int = adapterPosition
            val pokemon: Pokemon = listaPokemons[posicion]
            itemClickListener.onItemClick(pokemon)
        }
    }
}