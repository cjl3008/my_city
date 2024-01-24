package com.example.mycity.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mycity.R

val lato = FontFamily(
    Font(R.font.lato, FontWeight.Normal),
    Font(R.font.lato_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    labelMedium = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = lato
    ),
    titleMedium =  TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = lato
    ),
    bodyMedium = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily.SansSerif
    ),
)