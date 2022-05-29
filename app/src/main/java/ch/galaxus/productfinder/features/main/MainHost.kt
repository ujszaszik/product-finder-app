package ch.galaxus.productfinder.features.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import ch.galaxus.productfinder.compose.keyboard.keyboardAsState
import ch.galaxus.productfinder.coroutines.collectAsStateValue
import ch.galaxus.productfinder.features.products.search.ProductSearchHost
import ch.galaxus.productfinder.navigation.graph.ApplicationGraph
import ch.galaxus.productfinder.navigation.graph.LocalNavController
import ch.galaxus.productfinder.navigation.host.BackPressStrategy
import ch.galaxus.productfinder.navigation.host.Host
import ch.galaxus.productfinder.navigation.host.extractHost
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.imePadding
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun MainHost(viewModel: MainViewModel) {

    val navController = LocalNavController.current

    var host by remember { mutableStateOf<Host?>(null) }

    navController.addOnDestinationChangedListener { _, destination, _ ->
        host = destination.label.toString().extractHost()
    }

    val onBackPressed = viewModel.onBackPressed.collectAsStateValue()

    LaunchedEffect(onBackPressed) {
        if (true == onBackPressed) {
            when (host?.backPressStrategy) {
                BackPressStrategy.POP_BACKSTACK -> navController.popBackStack()
                BackPressStrategy.EXIT_APPLICATION -> viewModel.onExitRequest()
                BackPressStrategy.GO_TO_MAIN_SCREEN -> navController.navigate(ProductSearchHost.route)
                else -> Unit
            }
            viewModel.resetBackPress()
        }
    }

    val isKeyboardOpened = keyboardAsState().value.isOpened()

    var scaffoldModifier = Modifier.statusBarsPadding()
    if (!isKeyboardOpened) scaffoldModifier = scaffoldModifier.navigationBarsWithImePadding()

    ProvideWindowInsets {
        Scaffold(
            modifier = scaffoldModifier,
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .imePadding()
                ) { ApplicationGraph() }
            },
        )
    }
}