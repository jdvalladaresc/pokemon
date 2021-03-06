package com.pokemon.jv.internal.dagger.component

import com.pokemon.jv.internal.dagger.PerFragment
import com.pokemon.jv.internal.dagger.module.FragmentModule
import com.pokemon.jv.ui.fragments.ListPokemonFragment
import dagger.Component

@PerFragment
@Component(dependencies = [ApplicationComponent::class], modules = [FragmentModule::class])
interface ListPokemonFragmentComponent {
    fun inject(fragment: ListPokemonFragment)
}