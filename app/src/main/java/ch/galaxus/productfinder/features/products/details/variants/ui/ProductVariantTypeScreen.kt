package ch.galaxus.productfinder.features.products.details.variants.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import ch.galaxus.productfinder.compose.image.NetworkImage
import ch.galaxus.productfinder.compose.image.NetworkImageSize
import ch.galaxus.productfinder.compose.layout.CenteredColumn
import ch.galaxus.productfinder.compose.resources.Colors
import ch.galaxus.productfinder.compose.resources.Dimens
import ch.galaxus.productfinder.compose.resources.Fonts
import ch.galaxus.productfinder.features.products.details.variants.model.VariantDimension
import com.google.accompanist.flowlayout.FlowRow

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductVariantTypeScreen(dimension: VariantDimension) {

    CenteredColumn {

        FlowRow {

            dimension.variants.forEach { item ->

                Card(
                    modifier = Modifier
                        .padding(Dimens.paddingHalf)
                        .fillMaxWidth(dimension.type.screenRatio),
                    backgroundColor = Colors.white,
                    border = BorderStroke(Dimens.defaultBorderWidth, Colors.steelGray)
                ) {

                    CenteredColumn(modifier = Modifier.padding(Dimens.paddingDefault)) {

                        if (dimension.type.isImage()) {
                            NetworkImage(url = item.imageUrl, size = NetworkImageSize.MEDIUM)
                        }

                        Text(
                            text = item.label,
                            fontSize = Dimens.defaultTextSize,
                            fontFamily = Fonts.slateProFamily,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(Dimens.paddingDefault)
                        )
                    } // CenteredColumn

                } // Card

            } // forEach

        } // FlowRow

    } // CenteredColumn
}