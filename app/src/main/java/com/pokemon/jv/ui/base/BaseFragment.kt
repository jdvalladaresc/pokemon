package com.pokemon.jv.ui.base

import androidx.fragment.app.Fragment
import com.pokemon.jv.AndroidApplication

abstract class BaseFragment : Fragment() {

    open fun getAndroidApplication(): AndroidApplication {
        return requireActivity().application as AndroidApplication
    }
}