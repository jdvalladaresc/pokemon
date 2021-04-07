package com.pokemon.jv.internal.dagger.module

import androidx.fragment.app.Fragment
import com.pokemon.jv.internal.dagger.PerFragment
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(private val mFragment: Fragment) {
    @Provides
    @PerFragment
    fun fragment(): Fragment {
        return mFragment
    }
}