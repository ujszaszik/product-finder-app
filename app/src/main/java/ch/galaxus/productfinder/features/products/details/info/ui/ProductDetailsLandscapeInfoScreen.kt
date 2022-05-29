package ch.galaxus.productfinder.features.products.details.info.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ch.galaxus.productfinder.compose.image.NetworkImage
import ch.galaxus.productfinder.compose.image.NetworkImageSize
import ch.galaxus.productfinder.compose.layout.DefaultSpacer
import ch.galaxus.productfinder.compose.layout.DoubleSpacer
import ch.galaxus.productfinder.compose.resources.Colors
import ch.galaxus.productfinder.compose.resources.Dimens
import ch.galaxus.productfinder.compose.resources.Fonts
import ch.galaxus.productfinder.compose.scroll.enableVerticalScroll
import ch.galaxus.productfinder.compose.slider.Slider
import ch.galaxus.productfinder.compose.slider.SliderIndicator
import ch.galaxus.productfinder.features.products.details.common.ui.ProductNameText
import ch.galaxus.productfinder.features.products.details.common.ui.ProductPriceText
import ch.galaxus.productfinder.features.products.details.info.model.ProductDetailsModel
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ProductDetailsLandscapeInfoScreen(itemDetails: ProductDetailsModel, pagerState: PagerState) {

    Column(modifier = Modifier.enableVerticalScroll()) {

        Row(modifier = Modifier.fillMaxWidth()) {

            Column(modifier = Modifier.weight(1f)) {

                Slider(
                    elements = itemDetails.imageUrls,
                    pagerState = pagerState
                ) { item -> NetworkImage(item, NetworkImageSize.LARGE) }

                DoubleSpacer()

                SliderIndicator(
                    pagerState = pagerState,
                    size = itemDetails.imageUrls.size,
                )

                DefaultSpacer()

                Text(
                    text = ProductDetailsInfoTexts.imageAmountText(itemDetails.imageUrls.size),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                DefaultSpacer()

            }

            Column(modifier = Modifier.weight(1f)) {

                FlowRow(
                    modifier = Modifier
                        .height(30.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                        .padding(Dimens.paddingDefault),
                ) {

                    ProductNameText(
                        brandName = itemDetails.brandName,
                        name = itemDetails.name,
                        fontSize = Dimens.productInfoTextSize,
                        needsMeasurement = false,
                        allowedLines = 2
                    )
                }

                ProductPriceText(
                    price = itemDetails.price.amount,
                    fontSize = Dimens.productPriceTextSize
                )

                itemDetails.nameProperties?.let {
                    Text(
                        modifier = Modifier.padding(Dimens.paddingDefault),
                        text = it,
                        color = Colors.black,
                        fontFamily = Fonts.slateProFamily,
                        fontSize = Dimens.highlightTextSize,
                        fontWeight = FontWeight.Bold
                    )
                }
            } // Column
        } // Row
    } // Column
}