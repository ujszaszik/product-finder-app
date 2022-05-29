package ch.galaxus.productfinder.compose.slider

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ch.galaxus.barcodereader.extensions.clickable
import ch.galaxus.productfinder.compose.resources.Dimens
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.flow.FlowCollector

@OptIn(ExperimentalPagerApi::class, kotlinx.coroutines.InternalCoroutinesApi::class)
@Composable
fun <T> Slider(
    modifier: Modifier = Modifier,
    elements: List<T>,
    pagerState: PagerState,
    onPageClick: (Int, T) -> Unit = { _, _ -> },
    onPageShown: (Int, T) -> Unit = { _, _ -> },
    screen: @Composable (T) -> Unit,
) {

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }
            .collect(FlowCollector { value ->
                onPageShown.invoke(value, elements[value])
            })
    }

    HorizontalPager(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(Dimens.paddingDefault)
            .then(modifier),
        count = elements.size,
        state = pagerState,
        verticalAlignment = Alignment.Top
    ) { pageNumber ->
        val currentElement = elements[pageNumber]
        Column(
            modifier = Modifier
                .clickable(
                    onClick = { onPageClick.invoke(pageNumber, currentElement) },
                    rippleEffect = false
                )
        ) { screen.invoke(currentElement) }
    }
}