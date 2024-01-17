package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapterRecyclerViewCapturados: AdapterRecyclerView
    private lateinit var adapterRecyclerViewNoCapturados: AdapterRecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaPokemon = mutableListOf<Pokemon>(
            Pokemon("Pikachu", false),
            Pokemon("Raichu", false),
            Pokemon("Chicorita", false),
            Pokemon("Tyranitar", false),
            Pokemon("Bulbasur", false),
            Pokemon("Ivysur", false),
            Pokemon("Charmander", false),
            Pokemon("Polygon", false),
            Pokemon("Ditto", false),
            Pokemon("Nidoran", false),
            Pokemon("Shelgon", false),
            Pokemon("Articuno", false),
            Pokemon("Moltres", false),
            Pokemon("Zapdos", false),
            Pokemon("Entei", false),
        )

        val listaPokemonCapturados = mutableListOf<Pokemon>()
        val listaPokemonNoCapturados = mutableListOf<Pokemon>()
        listaPokemon.forEach { pokemon ->
            if(pokemon.capturado){
                listaPokemonCapturados.add(pokemon)
            }else{
                listaPokemonNoCapturados.add(pokemon)
            }
        }

        adapterRecyclerViewCapturados = AdapterRecyclerView(listaPokemonCapturados, this)
        adapterRecyclerViewNoCapturados = AdapterRecyclerView(listaPokemonNoCapturados, this)
        //apply permite realizar múltiples configuraciones en binding.rv sin tener que repetir binding.rv.
        binding.rvCapturados.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterRecyclerViewCapturados
        }

        binding.rvNoCapturados.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterRecyclerViewNoCapturados
        }
    }

    override fun onItemClick(pokemon: Pokemon) {
        val estaSeleccionado = pokemon.capturado
        if(estaSeleccionado){

        }else{

        }
    }
}