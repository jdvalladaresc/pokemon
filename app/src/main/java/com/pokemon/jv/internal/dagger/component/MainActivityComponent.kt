package com.pokemon.jv.internal.dagger.component

import com.pokemon.jv.internal.dagger.PerActivity
import com.pokemon.jv.ui.activities.MainActivity
import dagger.Component

@PerActivity
@Component(dependencies = [ApplicationComponent::class])
interface MainActivityComponent {
    fun inject(activity: MainActivity)
}