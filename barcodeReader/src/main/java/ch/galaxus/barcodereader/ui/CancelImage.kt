package ch.galaxus.barcodereader.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import ch.galaxus.barcodereader.R
import ch.galaxus.barcodereader.extensions.clickable
import ch.galaxus.barcodereader.resources.Dimens

@Composable
fun CancelImage(onClick: () -> Unit) {
    Image(
        painter = painterResource(R.drawable.ic_round_close_24),
        contentDescription = "",
        modifier = Modifier
            .clickable(onClick = { onClick.invoke() }, rippleEffect = false)
            .size(Dimens.cancelImageSize)
    )
}