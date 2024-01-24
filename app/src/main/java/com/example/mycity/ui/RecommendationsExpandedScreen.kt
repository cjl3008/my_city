package com.example.mycity.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mycity.model.Outlet

@Composable
fun RecommendationsExpandedScreen(
    selectedOutlet: Outlet,
    recommendations: List<Outlet>,
    onRecommendationCardClicked: (Outlet) -> Unit,
    screenHeight: WindowHeightSizeClass,
    paddingValues: PaddingValues
){
    Row(modifier = Modifier.fillMaxWidth()){
        RecommendationsScreen(
            recommendations = recommendations,
            onCardClicked = onRecommendationCardClicked,
            modifier = Modifier.weight(0.499f),
            showSelected = true,
            paddingValues = paddingValues
        )
        Divider(
            modifier = Modifier
                .fillMaxHeight(0.8f)
                .weight(0.001f),
            color = MaterialTheme.colorScheme.outlineVariant
        )
        DetailScreen(
            outlet = selectedOutlet,
            modifier = Modifier.weight(0.5f),
            screenHeight = screenHeight,
            paddingValues = paddingValues,
        )
    }
}