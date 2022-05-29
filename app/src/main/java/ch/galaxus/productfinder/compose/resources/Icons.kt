package ch.galaxus.productfinder.compose.resources

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ch.galaxus.productfinder.extension.empty

object Icons {

    @Composable
    fun ExitIcon() {
        Icon(
            Icons.Default.Logout,
            contentDescription = String.empty,
            tint = Colors.white
        )
    }

    @Composable
    fun SearchIcon() {
        Icon(
            Icons.Default.Search,
            contentDescription = String.empty,
            tint = Colors.white
        )
    }

    @Composable
    fun BackArrowIcon() {
        Icon(
            Icons.Default.ArrowBack,
            contentDescription = String.empty,
            modifier = Modifier
                .padding(Dimens.paddingDefault)
                .size(Dimens.largerIconSize),
            tint = Colors.white
        )
    }

}