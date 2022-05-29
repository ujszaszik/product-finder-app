package ch.galaxus.productfinder.compose.image

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import ch.galaxus.productfinder.compose.progress.ProgressBar
import ch.galaxus.productfinder.extension.empty
import coil.compose.SubcomposeAsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest

@Composable
fun NetworkImage(url: String?, size: NetworkImageSize) {

    if (url != null) {
        SubcomposeAsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(url)
                .crossfade(true)
                .memoryCachePolicy(CachePolicy.ENABLED)
                .build(),
            loading = { ProgressBar() },
            contentDescription = String.empty,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .height(size.height)
                .fillMaxWidth()
        )
    } else ImagePlaceholder(size.height)
}