package ch.galaxus.productfinder.compose.separator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ch.galaxus.productfinder.compose.resources.Colors
import ch.galaxus.productfinder.compose.resources.Dimens

@Composable
fun VerticalSeparator() {
    Divider(
        modifier = Modifier
            .padding(Dimens.paddingDefault)
            .height(Dimens.defaultSeparatorSize)
            .background(Colors.gray)
    )
}

@Composable
fun HorizontalSeparator() {
    Divider(
        modifier = Modifier
            .padding(Dimens.paddingDefault)
            .width(Dimens.defaultSeparatorSize)
            .background(Colors.gray)
    )
}