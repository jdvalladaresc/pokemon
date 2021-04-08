package com.pokemon.jv.ui.activities

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import com.pokemon.jv.databinding.ActivityPokemonDetailBinding
import com.pokemon.jv.model.PokemonModel
import com.pokemon.jv.ui.base.BaseActivity
import com.pokemon.jv.ui.views.PokemonDetailView

class PokemonDetailActivity : BaseActivity(), PokemonDetailView {
    private lateinit var binding: ActivityPokemonDetailBinding

    companion object {
        const val ITEM = "item"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initUI()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun initUI() {
        if (intent.hasExtra(ITEM)) {
            val item = intent.getParcelableExtra<PokemonModel>(ITEM)
            if (item != null) {
                title = item.name
            }
        }
    }

    override fun context(): Context {
        return this
    }

    override fun showErrorMessage(message: String) {

    }

    override fun showErrorNetworkMessage(message: String) {

    }
}