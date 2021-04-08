package com.pokemon.jv.internal.dagger.component

import com.pokemon.jv.internal.dagger.PerActivity
import com.pokemon.jv.internal.dagger.module.ActivityModule
import com.pokemon.jv.ui.activities.LoginActivity
import dagger.Component

@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface LoginActivityComponent {
    fun inject(activity: LoginActivity)
}