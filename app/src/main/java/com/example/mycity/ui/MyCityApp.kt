package com.example.mycity.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycity.R
import com.example.mycity.model.MyCityViewModel
import com.example.mycity.ui.utils.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp(screenSize: WindowSizeClass){
    val viewModel: MyCityViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    val width = screenSize.widthSizeClass

    Scaffold(topBar = {
        MyCityTopBar(
            label = uiState.label,
            onBackPressed = {
                viewModel.navigateBack(it)
            },
            screenType = uiState.screenType,
            screenWidth = width
        )
    }) { paddingValues ->
        when(width){
            WindowWidthSizeClass.Expanded -> {
                when(uiState.screenType){
                    Screens.CATEGORIES -> {
                        CategoriesExpandedScreen(
                            categories = uiState.categories,
                            recommendations = uiState.recommendations,
                            onCategoryCardClicked = { category ->
                                viewModel.showRecommendationsExpandedMode(category)
                            },
                            onRecommendationCardClicked = { outlet ->
                                viewModel.showOutletExpandedMode(outlet)
                            },
                            paddingValues = paddingValues
                        )
                    }
                    else -> {
                        RecommendationsExpandedScreen(
                            selectedOutlet = uiState.selectedOutlet,
                            recommendations = uiState.recommendations,
                            onRecommendationCardClicked = { outlet ->
                                viewModel.showOutletExpandedMode(outlet)
                            },
                            screenHeight = screenSize.heightSizeClass,
                            paddingValues = paddingValues
                        )
                    }
                }
            }
            else -> {
                when(uiState.screenType){
                    Screens.CATEGORIES ->
                        CategoriesScreen(
                            categories = uiState.categories,
                            onCardClicked = { category ->
                                viewModel.showRecommendations(category)
                            },
                            paddingValues = paddingValues
                        )
                    Screens.RECOMMENDATIONS ->
                        RecommendationsScreen(
                            recommendations = uiState.recommendations,
                            onCardClicked = { outlet ->
                                viewModel.showOutlet(outlet)
                            },
                            paddingValues = paddingValues
                        )
                    Screens.DETAIL ->
                        DetailScreen(
                            outlet = uiState.selectedOutlet,
                            screenHeight = screenSize.heightSizeClass,
                            paddingValues = paddingValues
                        )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MyCityTopBar(
    @StringRes label: Int,
    onBackPressed: (Screens) -> Unit,
    screenType: Screens,
    screenWidth: WindowWidthSizeClass
){
    val context = LocalContext.current
    val builder = StringBuilder()

    val labelText = when(screenWidth){
                        WindowWidthSizeClass.Expanded -> {
                            when(screenType){
                                Screens.CATEGORIES ->
                                    builder
                                        .append(context.getString(R.string.app_name))
                                        .append(context.getString(R.string.dash))
                                        .append(context.getString(R.string.recommended))
                                        .append(context.getString(R.string.space))
                                        .append(context.getString(label))
                                        .toString()
                                else ->
                                    builder
                                        .append(context.getString(R.string.recommended))
                                        .append(context.getString(R.string.space))
                                        .append(context.getString(R.string.colon))
                                        .append(context.getString(label))
                                        .toString()
                            }
                        }
                        else -> {
                            when(screenType){
                                Screens.CATEGORIES ->
                                    context.getString(R.string.app_name)
                                Screens.RECOMMENDATIONS ->
                                    builder
                                        .append(context.getString(R.string.recommended))
                                        .append(context.getString(R.string.space))
                                        .append(context.getString(label))
                                        .toString()
                                else ->
                                    context.getString(label)
                            }
                        }
                    }

    TopAppBar(
        title = {
                Text(
                    text = labelText,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.labelMedium
                )
        },
        navigationIcon = {
            if(screenType != Screens.CATEGORIES){
                IconButton(
                    onClick = { onBackPressed(screenType) },
                    modifier = Modifier
                        .padding(
                            start = dimensionResource(R.dimen.padding_small),
                            end = dimensionResource(R.dimen.padding_medium)
                        )
                        .background(
                            color = MaterialTheme.colorScheme.primaryContainer,
                            shape = CircleShape
                        )
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
    )
}