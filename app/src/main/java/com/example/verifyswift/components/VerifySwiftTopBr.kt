package com.example.verifyswift.components

import android.content.res.Configuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrightnessMedium
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerifySwiftTopBar(
    isLightTheme: () -> Unit
) {

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Verify Swift"
            )
        },
        actions = {
            IconButton(
                onClick = isLightTheme
            ) {
                Icon(Icons.Default.BrightnessMedium, contentDescription = null)
            }
        }
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
fun VerifySwiftTopBarDark() {
    VerifySwiftTopBar {}
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
fun VerifySwiftTopBarLight() {
    VerifySwiftTopBar {}

}