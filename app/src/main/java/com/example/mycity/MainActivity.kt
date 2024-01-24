package com.example.mycity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.example.mycity.ui.MyCityApp
import com.example.mycity.ui.theme.MyCityTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCityTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val screenSize = calculateWindowSizeClass(activity = this)
                    MyCityApp(screenSize)
                }
            }
        }
    }
}

// Tablet width=1280, height=800 ~ Expanded
// Foldable width=673, height=841 ~ Medium
// Phone width=480, height=891 ~ Compact
const val widthDp: Int = 480
const val heightDp: Int = 891

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(
    widthDp = widthDp,
    heightDp = heightDp,
    showBackground = true
)
@Composable
fun MyCityPreview(){
    val windowSize = WindowSizeClass.calculateFromSize(DpSize(widthDp.dp, heightDp.dp))

    MyCityTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MyCityApp(windowSize)
        }
    }
}