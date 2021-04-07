package com.pokemon.jv.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pokemon.jv.R
import com.pokemon.jv.ui.ListPokemonViewModel
import com.pokemon.jv.ui.base.BaseFragment
import com.pokemon.jv.ui.presenter.ListPokemonPresenter
import com.pokemon.jv.ui.views.ListPokemonView
import javax.inject.Inject

class ListPokemonFragment : BaseFragment(), ListPokemonView {

    private lateinit var listPokemonViewModel: ListPokemonViewModel

    @Inject
    private lateinit var presenter: ListPokemonPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        listPokemonViewModel =
            ViewModelProviders.of(this).get(ListPokemonViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_list_pokemon, container, false)
        /*val textView: TextView = root.findViewById(R.id.text_home)
        listPokemonViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
         */
        return root
    }
}