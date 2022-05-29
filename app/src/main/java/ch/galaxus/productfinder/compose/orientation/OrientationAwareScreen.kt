package ch.galaxus.productfinder.compose.orientation

import android.content.res.Configuration
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalConfiguration
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.FlowCollector

@OptIn(InternalCoroutinesApi::class)
@Composable
fun OrientationAwareScreen(
    portraitModeScreen: @Composable () -> Unit,
    landscapeModeScreen: @Composable () -> Unit
) {

    var orientation by remember { mutableStateOf(Configuration.ORIENTATION_PORTRAIT) }

    val configuration = LocalConfiguration.current

    LaunchedEffect(configuration) {
        snapshotFlow { configuration.orientation }
            .collect(FlowCollector { orientation = it })
    }

    when (orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> landscapeModeScreen()
        else -> portraitModeScreen()
    }
}