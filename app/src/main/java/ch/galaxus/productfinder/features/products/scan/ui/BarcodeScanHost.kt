package ch.galaxus.productfinder.features.products.scan.ui

import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import ch.galaxus.productfinder.coroutines.collectAsStateValue
import ch.galaxus.productfinder.extension.vibrate
import ch.galaxus.productfinder.features.products.details.common.ui.ProductDetailsHost
import ch.galaxus.productfinder.features.products.scan.ui.dialog.InvalidEanCodeErrorDialog
import ch.galaxus.productfinder.features.products.scan.util.rememberPlayServicesState
import ch.galaxus.productfinder.navigation.graph.LocalNavController
import ch.galaxus.productfinder.navigation.host.Host
import ch.galaxus.productfinder.navigation.host.withData
import com.google.android.gms.common.ConnectionResult

private const val BASE_VIBRATION_LENGTH: Long = 200L

val BarcodeScanHost = Host(route = "BarcodeScan")

@Composable
fun BarcodeScanHost(viewModel: BarcodeScanViewModel = hiltViewModel()) {

    val context = LocalContext.current
    val navController = LocalNavController.current

    val playServicesState = rememberPlayServicesState()

    if (playServicesState.value != ConnectionResult.SUCCESS) {
        PlayServicesNotInstalledErrorDialog { navController.navigateUp() }
    }

    val parsedEanCode = viewModel.parsedEanCode.collectAsStateValue()
    val eanCodeError = viewModel.error.collectAsStateValue() ?: false

    var showEanCodeError by remember { mutableStateOf(false) }

    LaunchedEffect(parsedEanCode) {
        parsedEanCode?.let {
            context.vibrate(BASE_VIBRATION_LENGTH)
            navController.navigate(ProductDetailsHost.withData(it))
        }
    }

    LaunchedEffect(eanCodeError) {
        showEanCodeError = eanCodeError
    }

    if (showEanCodeError) InvalidEanCodeErrorDialog {
        navController.navigateUp()
    }

    BarcodeScanScreen(
        onDetection = { viewModel.acceptBarCode(it) },
        onCancel = { navController.navigateUp() },
        onToggleFlash = { viewModel.toggleFlash() },
        isFlashOn = viewModel.isFlashTurnedOn.collectAsStateValue() ?: false
    )

}