package ch.galaxus.productfinder.features.products.search

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ch.galaxus.productfinder.compose.toast.LongToast
import ch.galaxus.productfinder.coroutines.collectAsStateValue
import ch.galaxus.productfinder.extension.isCameraPermissionGranted
import ch.galaxus.productfinder.features.products.details.common.ui.ProductDetailsHost
import ch.galaxus.productfinder.features.products.scan.ui.BarcodeScanHost
import ch.galaxus.productfinder.navigation.graph.LocalNavController
import ch.galaxus.productfinder.navigation.host.BackPressStrategy
import ch.galaxus.productfinder.navigation.host.Host
import ch.galaxus.productfinder.navigation.host.withData

val ProductSearchHost = Host(
    route = "ProductSearch",
    backPressStrategy = BackPressStrategy.EXIT_APPLICATION
)

fun NavController.navigateToSearch() =
    navigate(ProductSearchHost.route) {
        popUpTo(ProductSearchHost.route) { inclusive = true }
    }

@Composable
fun ProductSearchHost(viewModel: ProductSearchViewModel = hiltViewModel()) {

    val searchInputError = viewModel.searchedCodeInput.collectErrorState()

    val searchedKeyword = viewModel.searchedEanCode.collectAsStateValue()
    val navController = LocalNavController.current

    LaunchedEffect(key1 = searchedKeyword) {
        searchedKeyword?.let {
            viewModel.resetKeyword()
            navController.navigate(ProductDetailsHost.withData(it))
        }
    }

    val context = LocalContext.current

    var isCameraPermissionGranted by remember { mutableStateOf<Boolean?>(null) }
    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isCameraPermissionGranted = it }

    var showPermissionDeniedToast by remember { mutableStateOf(false) }

    when (isCameraPermissionGranted) {
        true -> navController.navigate(BarcodeScanHost.route)
        false -> showPermissionDeniedToast = true
        else -> Unit
    }

    ProductSearchScreen(
        errorMessage = searchInputError,
        onTextChanged = { viewModel.onSearchTextChange(it) },
        onSearchRequested = { viewModel.onSearchRequest() },
        onBarcodeScanRequest = {
            if (context.isCameraPermissionGranted()) navController.navigate(BarcodeScanHost.route)
            else launcher.launch(Manifest.permission.CAMERA)
        },
    )

    LongToast(
        isVisible = showPermissionDeniedToast,
        message = ProductSearchTexts.NEEDS_CAMERA_PERMISSION
    )

}