package com.example.mycity.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Outlet(
    @StringRes val name: Int,
    @DrawableRes val image: Int,
    @StringRes val category: Int,
    @StringRes val content: Int,
    var selected: Boolean = false
)
