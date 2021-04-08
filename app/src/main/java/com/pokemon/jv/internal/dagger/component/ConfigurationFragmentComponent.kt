package com.pokemon.jv.internal.dagger.component

import com.pokemon.jv.internal.dagger.PerFragment
import com.pokemon.jv.internal.dagger.module.FragmentModule
import com.pokemon.jv.ui.fragments.ConfigurationFragment
import dagger.Component

@PerFragment
@Component(dependencies = [ApplicationComponent::class], modules = [FragmentModule::class])
interface ConfigurationFragmentComponent {
    fun inject(fragment: ConfigurationFragment)
}