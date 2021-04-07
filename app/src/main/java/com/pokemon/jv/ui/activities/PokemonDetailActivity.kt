package com.pokemon.jv.ui.activities

import android.os.Bundle
import com.pokemon.jv.R
import com.pokemon.jv.ui.base.BaseActivity
import com.pokemon.jv.ui.views.PokemonDetailView

class PokemonDetailActivity : BaseActivity(), PokemonDetailView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)
    }
}