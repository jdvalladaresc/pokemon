package com.pokemon.jv.ui.activities

import android.content.Context
import android.os.Bundle
import com.pokemon.jv.R
import com.pokemon.jv.ui.base.BaseActivity
import com.pokemon.jv.ui.views.PokemonDetailView

class PokemonDetailActivity : BaseActivity(), PokemonDetailView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun initUI() {

    }

    override fun context(): Context {
        return this
    }

    override fun showErrorMessage(message: String) {

    }

    override fun showErrorNetworkMessage(message: String) {

    }
}