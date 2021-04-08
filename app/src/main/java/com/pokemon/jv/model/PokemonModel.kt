package com.pokemon.jv.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class PokemonModel(
    var id: Int = 0,
    var name: String? = null,
    var url: String? = null
) : Parcelable