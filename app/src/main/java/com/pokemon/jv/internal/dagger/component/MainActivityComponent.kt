package com.pokemon.jv.internal.dagger.component

import com.pokemon.jv.internal.dagger.PerActivity
import com.pokemon.jv.internal.dagger.module.ActivityModule
import com.pokemon.jv.internal.dagger.module.FragmentModule
import com.pokemon.jv.ui.activities.MainActivity
import dagger.Component

@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface MainActivityComponent {
    fun inject(activity: MainActivity)
}