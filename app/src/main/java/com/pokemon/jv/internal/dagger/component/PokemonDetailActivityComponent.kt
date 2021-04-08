package com.pokemon.jv.internal.dagger.component

import com.pokemon.jv.internal.dagger.PerActivity
import com.pokemon.jv.internal.dagger.module.ActivityModule
import com.pokemon.jv.ui.activities.PokemonDetailActivity
import dagger.Component

@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface PokemonDetailActivityComponent {
    fun inject(activity: PokemonDetailActivity)
}