package ch.galaxus.productfinder.features.main.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import ch.galaxus.productfinder.features.products.search.navigateToSearch
import ch.galaxus.productfinder.navigation.graph.LocalNavController
import ch.galaxus.productfinder.navigation.host.Host

val SplashHost = Host(route = "SplashHost")

@Composable
fun SplashHost(viewModel: SplashViewModel = hiltViewModel()) {

    val isSplashFinished = viewModel.isSplashFinished.observeAsState().value ?: false

    if (isSplashFinished) {
        LocalNavController.current.navigateToSearch()
    }

    SplashScreen()
}