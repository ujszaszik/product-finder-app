package ch.galaxus.productfinder.compose.tab

import androidx.compose.runtime.Composable

data class TabScreenInfo(
    val label: String,
    val screen: @Composable () -> Unit
)