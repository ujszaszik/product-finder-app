package ch.galaxus.productfinder.features.products.details.variants.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import ch.galaxus.productfinder.compose.layout.DefaultSpacer
import ch.galaxus.productfinder.compose.layout.DoubleSpacer
import ch.galaxus.productfinder.compose.layout.TopCenterColumn
import ch.galaxus.productfinder.compose.resources.Dimens
import ch.galaxus.productfinder.compose.resources.Fonts
import ch.galaxus.productfinder.compose.separator.VerticalSeparator
import ch.galaxus.productfinder.features.products.details.variants.model.ProductVariantsModel

@Composable
fun ProductVariantsListScreen(productVariants: ProductVariantsModel) {

    TopCenterColumn {

        DoubleSpacer()

        LazyColumn(
            modifier = Modifier
                .padding(Dimens.paddingDefault)
                .fillMaxWidth()
        ) {

            items(productVariants.variants) { dimension ->

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = dimension.name,
                    textAlign = TextAlign.Center,
                    fontFamily = Fonts.slateProFamily,
                    fontSize = Dimens.titleTextSize,
                    fontWeight = FontWeight.Bold
                )

                DefaultSpacer()

                ProductVariantTypeScreen(dimension)

                DefaultSpacer()

                VerticalSeparator()

                DefaultSpacer()

            }
        }
    }
}