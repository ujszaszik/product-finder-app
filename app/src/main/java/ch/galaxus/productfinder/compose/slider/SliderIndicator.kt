package ch.galaxus.productfinder.compose.slider

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import ch.galaxus.productfinder.compose.layout.CenteredRow
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.flow.FlowCollector

@OptIn(ExperimentalPagerApi::class, kotlinx.coroutines.InternalCoroutinesApi::class)
@Composable
fun SliderIndicator(
    pagerState: PagerState,
    size: Int,
    style: SliderIndicatorStyle = SliderIndicatorStyle()
) {
    var currentIndex by remember { mutableStateOf(0) }

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }
            .collect(FlowCollector { value -> currentIndex = value })
    }

    CenteredRow {
        Spacer(modifier = Modifier.width(style.horizontalPadding))

        for (i in 0 until size) {
            val isHighlighted = currentIndex == i

            Canvas(modifier = Modifier.size(style.indicatorSize), onDraw = {

                drawCircle(
                    radius = style.indicatorRadius,
                    color = if (isHighlighted) style.highlightColor else style.defaultColor,
                    alpha = if (isHighlighted) style.highlightAlpha else style.defaultAlpha
                )
            })
        }
        Spacer(modifier = Modifier.width(style.horizontalPadding))
    }
}