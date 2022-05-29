package ch.galaxus.productfinder.features.products.details.accessories.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ch.galaxus.productfinder.compose.image.NetworkImage
import ch.galaxus.productfinder.compose.image.NetworkImageSize
import ch.galaxus.productfinder.compose.layout.CenteredColumn
import ch.galaxus.productfinder.compose.layout.DefaultSpacer
import ch.galaxus.productfinder.compose.resources.Colors
import ch.galaxus.productfinder.compose.resources.Dimens
import ch.galaxus.productfinder.compose.resources.Values
import ch.galaxus.productfinder.features.products.details.accessories.model.ProductAccessoriesModel
import ch.galaxus.productfinder.features.products.details.common.ui.ProductNameText
import ch.galaxus.productfinder.features.products.details.common.ui.ProductPriceText

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductAccessoriesListScreen(productAccessoriesModel: ProductAccessoriesModel) {

    val accessories = productAccessoriesModel.accessories

    CenteredColumn {

        LazyVerticalGrid(
            cells = GridCells.Fixed(Values.GRID_SIZE_LARGE),
            contentPadding = PaddingValues(Dimens.paddingDefault)
        ) {
            items(accessories) { item ->
                Card(
                    modifier = Modifier
                        .padding(Dimens.paddingHalf)
                        .fillMaxWidth(0.4F),
                    backgroundColor = Colors.white,
                    border = BorderStroke(Dimens.defaultBorderWidth, Colors.steelGray)
                ) {

                    CenteredColumn(modifier = Modifier.padding(Dimens.paddingDefault)) {

                        NetworkImage(url = item.imageUrl, size = NetworkImageSize.MEDIUM)

                        DefaultSpacer()

                        ProductPriceText(
                            price = item.price.amount,
                            fontSize = Dimens.highlightTextSize
                        )

                        DefaultSpacer()

                        ProductNameText(
                            brandName = item.brandName,
                            name = item.name,
                            fontSize = Dimens.defaultTextSize,
                            allowedLines = 2,
                            needsMeasurement = true
                        )
                    } // CenteredColumn

                } // Card

            } // forEach

        } // FlowRow

    } // CenteredColumn

}