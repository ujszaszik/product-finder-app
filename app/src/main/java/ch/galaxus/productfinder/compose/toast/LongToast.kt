package ch.galaxus.productfinder.compose.toast

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun LongToast(isVisible: Boolean, message: String?) {

    val toast = Toast.makeText(
        LocalContext.current,
        message,
        Toast.LENGTH_LONG
    )

    if (isVisible) toast.show()
    else toast.cancel()
}