package com.example.mycity.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mycity.model.Category
import com.example.mycity.model.Outlet

@Composable
fun CategoriesExpandedScreen(
    categories: List<Category>,
    recommendations: List<Outlet>,
    onCategoryCardClicked: (Category) -> Unit,
    onRecommendationCardClicked: (Outlet) -> Unit,
    paddingValues: PaddingValues
){
    Row(modifier = Modifier.fillMaxWidth()){
        CategoriesScreen(
            categories = categories,
            onCardClicked = onCategoryCardClicked,
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
        RecommendationsScreen(
            recommendations = recommendations,
            onCardClicked = onRecommendationCardClicked,
            modifier = Modifier.weight(0.5f),
            paddingValues = paddingValues
        )
    }
}