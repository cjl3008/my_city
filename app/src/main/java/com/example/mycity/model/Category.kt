package com.example.mycity.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    @StringRes val name: Int,
    @DrawableRes val thumbnail: Int,
    val recommendations: List<Outlet>,
    var selected: Boolean = false
)
