package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.example.mycity.R
import com.example.mycity.model.Outlet

@Composable
fun RecommendationsScreen(
    recommendations: List<Outlet>,
    onCardClicked: (Outlet) -> Unit,
    modifier: Modifier = Modifier,
    showSelected: Boolean = false,
    paddingValues: PaddingValues
){
    LazyColumn(
        modifier = modifier
            .padding(
                start = dimensionResource(R.dimen.padding_medium),
                top = dimensionResource(R.dimen.padding_medium),
                end = dimensionResource(R.dimen.padding_medium)
            ),
        contentPadding = paddingValues,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium))
    ){
        items(items = recommendations){
            ItemRecommendation(
                showSelected = showSelected,
                outlet = it,
                onCardClicked = onCardClicked
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ItemRecommendation(
    showSelected: Boolean,
    outlet: Outlet,
    onCardClicked: (Outlet) -> Unit
){
    val context = LocalContext.current

    Card(
        onClick = { onCardClicked(outlet) },
        shape = RoundedCornerShape(topStart = dimensionResource(R.dimen.padding_medium)),
        elevation = CardDefaults.cardElevation(defaultElevation = dimensionResource(R.dimen.card_elevation)),
        colors = if(showSelected && outlet.selected){
            CardDefaults.cardColors(MaterialTheme.colorScheme.outlineVariant)
        } else {
            CardDefaults.cardColors()
        }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(outlet.image),
                contentDescription = null,
                modifier = Modifier.size(dimensionResource(R.dimen.thumbnail_size))
            )
            Text(
                text = context.getString(outlet.name),
                modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_large)),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}