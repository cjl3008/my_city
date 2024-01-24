package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.core.text.HtmlCompat
import com.example.mycity.R
import com.example.mycity.model.Outlet
import com.example.mycity.ui.utils.toAnnotatedString
import eu.wewox.textflow.TextFlow

@Composable
fun DetailScreen(
    outlet: Outlet,
    modifier: Modifier = Modifier,
    screenHeight: WindowHeightSizeClass,
    paddingValues: PaddingValues
){
    val context = LocalContext.current
    val spanned = HtmlCompat.fromHtml(context.resources.getText(outlet.content).toString(), HtmlCompat.FROM_HTML_MODE_COMPACT)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                start = dimensionResource(R.dimen.padding_medium),
                top = paddingValues.calculateTopPadding() + dimensionResource(R.dimen.padding_medium),
                end = dimensionResource(R.dimen.padding_medium),
                bottom = dimensionResource(R.dimen.padding_medium)
            )
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        if(screenHeight != WindowHeightSizeClass.Compact){
            Image(
                painter = painterResource(outlet.image),
                contentDescription = null
            )
            Text(
                text = spanned.toAnnotatedString(),
                style = MaterialTheme.typography.bodyMedium
            )
        } else {
            TextFlow(
                text = spanned.toAnnotatedString(),
                style = MaterialTheme.typography.bodyMedium
            ) {
                Image(
                    painter = painterResource(outlet.image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize(0.5f)
                        .padding(
                            end = dimensionResource(R.dimen.padding_medium),
                            bottom = dimensionResource(R.dimen.padding_small)
                        )
                )
            }
        }
    }
}