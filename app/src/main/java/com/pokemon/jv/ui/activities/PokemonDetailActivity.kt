package com.pokemon.jv.ui.activities

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pokemon.jv.R
import com.pokemon.jv.databinding.ActivityPokemonDetailBinding
import com.pokemon.jv.internal.dagger.component.DaggerPokemonDetailActivityComponent
import com.pokemon.jv.model.DetailModel
import com.pokemon.jv.model.PokemonItemModel
import com.pokemon.jv.model.PokemonModel
import com.pokemon.jv.model.mapper.PokemonDetailModelMapper
import com.pokemon.jv.ui.adapters.DetailPokemonAdapter
import com.pokemon.jv.ui.base.BaseActivity
import com.pokemon.jv.ui.presenter.PokemonDetailPresenter
import com.pokemon.jv.ui.views.PokemonDetailView
import kotlinx.android.synthetic.main.activity_pokemon_detail.*
import kotlinx.android.synthetic.main.loading.*
import javax.inject.Inject

class PokemonDetailActivity : BaseActivity(), PokemonDetailView {
    private lateinit var binding: ActivityPokemonDetailBinding

    @Inject
    lateinit var presenter: PokemonDetailPresenter

    @Inject
    lateinit var adapterType: DetailPokemonAdapter

    @Inject
    lateinit var adapterEvolution: DetailPokemonAdapter

    @Inject
    lateinit var adapterAttack: DetailPokemonAdapter

    @Inject
    lateinit var adapterAbilities: DetailPokemonAdapter

    @Inject
    lateinit var adapterEncounters: DetailPokemonAdapter

    companion object {
        const val ITEM = "item"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        buildInjection()
        initUI()
    }

    private fun buildInjection() {
        DaggerPokemonDetailActivityComponent.builder()
            .applicationComponent(getApplicationComponent())
            .build().inject(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.resume()
    }

    override fun onPause() {
        super.onPause()
        presenter.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun getPokemonId(): Int {
        if (intent.hasExtra(ITEM)) {
            val item = intent.getParcelableExtra<PokemonModel>(ITEM)
            if (item != null)
                return item.id
        }
        return 0
    }

    override fun successPokemonDetail(model: PokemonItemModel) {
        adapterAbilities.addItems(PokemonDetailModelMapper.transformAbilitiesDetail(model.abilities))
        adapterAttack.addItems(PokemonDetailModelMapper.transformMovesDetail(model.moves))
        adapterType.addItems(PokemonDetailModelMapper.transformTypeDetail(model.type))
    }

    override fun successPokemonEncounter(list: List<DetailModel>?) {
        adapterEncounters.addItems(PokemonDetailModelMapper.transformEncountersDetail(list))
    }

    override fun successEvolutionChain(list: List<DetailModel>?) {
        adapterEvolution.addItems(PokemonDetailModelMapper.transformEvolutionDetail(list))
    }

    override fun showLoading() {
        loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loading.visibility = View.GONE
    }

    override fun initUI() {
        presenter.setView(this)

        binding.rvAbilities.layoutManager = LinearLayoutManager(this)
        binding.rvAbilities.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        binding.rvAbilities.adapter = adapterAbilities
        binding.rvAttack.layoutManager = LinearLayoutManager(this)
        binding.rvAttack.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        binding.rvAttack.adapter = adapterAttack
        binding.rvEncounters.layoutManager = LinearLayoutManager(this)
        binding.rvEncounters.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        binding.rvEncounters.adapter = adapterEncounters
        binding.rvEvolution.layoutManager = LinearLayoutManager(this)
        binding.rvEvolution.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        binding.rvEvolution.adapter = adapterEvolution
        binding.rvType.layoutManager = LinearLayoutManager(this)
        binding.rvType.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        binding.rvType.adapter = adapterType

        binding.flAbilities.tag = false
        binding.flEncounters.tag = false
        binding.flEvolution.tag = false
        binding.flMoves.tag = false
        binding.flType.tag = false

        binding.flType.setOnClickListener {
            changeState(binding.flType, binding.rvType)
        }
        binding.flMoves.setOnClickListener {
            changeState(binding.flMoves, binding.rvAttack)
        }
        binding.flEvolution.setOnClickListener {
            changeState(binding.flEvolution, binding.rvEvolution)
        }
        binding.flEncounters.setOnClickListener {
            changeState(binding.flEncounters, binding.rvEncounters)
        }
        binding.flAbilities.setOnClickListener {
            changeState(binding.flAbilities, binding.rvAbilities)
        }

        if (intent.hasExtra(ITEM)) {
            val item = intent.getParcelableExtra<PokemonModel>(ITEM)
            if (item != null) {
                title = item.name?.capitalize()
                Glide.with(context())
                    .load("https://pokeres.bastionbot.org/images/pokemon/${item.id}.png")
                    .placeholder(R.drawable.ic_placeholder)
                    .into(binding.ivImage)
            }
            presenter.getPokemonDetail()
        }
    }

    fun changeState(frameLayout: FrameLayout, recyclerView: RecyclerView) {
        if (frameLayout.tag as Boolean) {
            frameLayout.tag = false
            recyclerView.visibility = View.GONE
        } else {
            frameLayout.tag = true
            recyclerView.visibility = View.VISIBLE
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