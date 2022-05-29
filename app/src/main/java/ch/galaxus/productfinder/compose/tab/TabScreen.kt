package ch.galaxus.productfinder.compose.tab

import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ch.galaxus.productfinder.compose.layout.DoubleSpacer
import ch.galaxus.productfinder.compose.layout.TopCenterColumn
import ch.galaxus.productfinder.compose.resources.Colors

@Composable
fun TabScreen(screens: List<TabScreenInfo>) {
    var tabIndex by remember { mutableStateOf(0) }

    TopCenterColumn {

        TabRow(
            backgroundColor = Colors.primary,
            selectedTabIndex = tabIndex,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[tabIndex]),
                    height = 4.dp,
                    color = Color.Green
                )
            }
        ) {
            screens.forEachIndexed { index, _ ->
                Tab(selected = tabIndex == index, onClick = {
                    tabIndex = index
                }, text = {
                    Text(
                        text = screens[index].label,
                        color = Colors.white
                    )
                })
            }
        }

        DoubleSpacer()

        screens[tabIndex].screen()
    }

}