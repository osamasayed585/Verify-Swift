package com.example.verifyswift.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
                Icon(Icons.Filled.Settings, contentDescription = null)
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