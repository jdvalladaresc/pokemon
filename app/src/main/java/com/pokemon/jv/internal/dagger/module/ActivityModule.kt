package com.pokemon.jv.internal.dagger.module

import android.app.Activity
import com.pokemon.jv.internal.dagger.PerActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val mActivity: Activity) {
    @Provides
    @PerActivity
    fun activity(): Activity {
        return mActivity
    }
}