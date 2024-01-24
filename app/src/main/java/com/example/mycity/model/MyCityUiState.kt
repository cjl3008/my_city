package com.example.mycity.model

import androidx.annotation.StringRes
import com.example.mycity.data.MyCityDataProvider
import com.example.mycity.ui.utils.Screens

data class MyCityUiState(
    val screenType: Screens = Screens.CATEGORIES,
    @StringRes val label: Int = MyCityDataProvider.categories[0].name,
    val categories: List<Category> = MyCityDataProvider.categories,
    val recommendations : List<Outlet> = MyCityDataProvider.categories[0].recommendations,
    val selectedOutlet: Outlet = MyCityDataProvider.categories[0].recommendations[0]
)
