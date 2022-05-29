package ch.galaxus.productfinder.features.products.scan.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.common.GoogleApiAvailability

@Composable
fun rememberPlayServicesState(): State<Int> {
    val api = GoogleApiAvailability.getInstance()
    val resultCode = api.isGooglePlayServicesAvailable(LocalContext.current)
    return remember { mutableStateOf(resultCode) }
}