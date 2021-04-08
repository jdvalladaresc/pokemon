package com.pokemon.jv.ui.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pokemon.jv.databinding.FragmentListPokemonBinding
import com.pokemon.jv.internal.dagger.component.DaggerListPokemonFragmentComponent
import com.pokemon.jv.model.PokemonModel
import com.pokemon.jv.ui.ListPokemonViewModel
import com.pokemon.jv.ui.activities.PokemonDetailActivity
import com.pokemon.jv.ui.adapters.ListPokemonAdapter
import com.pokemon.jv.ui.base.BaseFragment
import com.pokemon.jv.ui.presenter.ListPokemonPresenter
import com.pokemon.jv.ui.views.ListPokemonView
import kotlinx.android.synthetic.main.fragment_list_pokemon.*
import kotlinx.android.synthetic.main.loading.*
import javax.inject.Inject


class ListPokemonFragment :
    BaseFragment(),
    ListPokemonView, ListPokemonAdapter.ListPokemonCallback {

    @Inject
    lateinit var presenter: ListPokemonPresenter
    private lateinit var listPokemonViewModel: ListPokemonViewModel
    private lateinit var binding: FragmentListPokemonBinding

    @Inject
    lateinit var adapter: ListPokemonAdapter

    private var isLoading = false
    private var data = ArrayList<PokemonModel?>()

    companion object {
        const val LIMIT = 20
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        buildInjection()
    }

    private fun buildInjection() {
        DaggerListPokemonFragmentComponent.builder()
            .applicationComponent(getAndroidApplication().getApplicationComponent())
            .build().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //listPokemonViewModel = ViewModelProviders.of(this).get(ListPokemonViewModel::class.java)
        binding = FragmentListPokemonBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initUI()
    }

    override fun successListPokemon(list: List<PokemonModel>?) {
        if (list != null) {
            data.addAll(list)
            adapter.addItems(data)
            isLoading = false
        }
    }

    override fun showLoading() {
        loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loading.visibility = View.GONE
    }

    override fun initUI() {
        presenter.setView(this)
        adapter.setListPokemonCallback(this)
        binding.rvPokemons.layoutManager = LinearLayoutManager(context())
        binding.rvPokemons.adapter = adapter
        initScrollListener()
        presenter.getPokemonList(0, LIMIT)
    }

    private fun initScrollListener() {
        rvPokemons.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(
                @NonNull recyclerView: RecyclerView,
                newState: Int
            ) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(
                @NonNull recyclerView: RecyclerView,
                dx: Int,
                dy: Int
            ) {
                super.onScrolled(recyclerView, dx, dy)
                val linearLayoutManager =
                    recyclerView.layoutManager as LinearLayoutManager?
                if (!isLoading) {
                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == adapter.itemCount - 1) {
                        loadMore()
                        isLoading = true
                    }
                }
            }
        })
    }

    private fun loadMore() {
        presenter.getPokemonList(data.size + 1, data.size + LIMIT)
    }

    override fun context(): Context {
        return requireContext()
    }

    override fun showErrorMessage(message: String) {

    }

    override fun showErrorNetworkMessage(message: String) {

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

    override fun onClick(model: PokemonModel, position: Int) {
        val intent = Intent(context(), PokemonDetailActivity::class.java)
        intent.putExtra(PokemonDetailActivity.ITEM, model)
        startActivity(intent)
    }
}