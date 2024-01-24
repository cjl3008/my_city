package com.example.mycity.model

import androidx.lifecycle.ViewModel
import com.example.mycity.data.MyCityDataProvider
import com.example.mycity.ui.utils.Screens
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MyCityViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(MyCityUiState())
    val uiState = _uiState.asStateFlow()

    fun showRecommendations(category: Category){
        _uiState.update {
            it.copy(
                screenType = Screens.RECOMMENDATIONS,
                label = category.name,
                recommendations = category.recommendations,

            )
        }
    }

    fun showRecommendationsExpandedMode(category: Category){
        MyCityDataProvider.selectActiveCategory(category.name)

        _uiState.update {
            it.copy(
                label = category.name,
                recommendations = category.recommendations,

                )
        }
    }

    fun showOutlet(outlet: Outlet){
        _uiState.update {
            it.copy(
                screenType = Screens.DETAIL,
                label = outlet.name,
                selectedOutlet = outlet
            )
        }
    }

    fun showOutletExpandedMode(outlet: Outlet){
        MyCityDataProvider.selectActiveOutlet(outlet.name)

        _uiState.update {
            it.copy(
                screenType = Screens.RECOMMENDATIONS,
                label = outlet.name,
                selectedOutlet = outlet
            )
        }
    }

    fun navigateBack(currentScreen: Screens){
        if(currentScreen == Screens.RECOMMENDATIONS){
            _uiState.update {
                it.copy(
                    screenType = Screens.CATEGORIES,
                    label = it.selectedOutlet.category
                )
            }
        }
        else if(currentScreen == Screens.DETAIL){
            _uiState.update {
                it.copy(
                    screenType = Screens.RECOMMENDATIONS,
                    label = it.selectedOutlet.category
                )
            }
        }
    }
}