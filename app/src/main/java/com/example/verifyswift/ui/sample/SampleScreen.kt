package com.example.verifyswift.ui.sample

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.droidDevOs.verifyswift.base.SwiftAuth
import com.example.verifyswift.R
import com.example.verifyswift.components.ChooserItem
import com.example.verifyswift.theme.VerifySwiftTheme
import com.example.verifyswift.ui.sample.state.ShapesOptions
import com.example.verifyswift.ui.sample.state.StatesOptions


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SampleScreen(
    innerPadding: PaddingValues = PaddingValues(),
    viewModel: SampleViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()


    if (uiState.isCloseKeyboard)
        LocalSoftwareKeyboardController.current?.hide()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
            .padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        SwiftAuth(
            otpValue = uiState.otp,
            pinCount = 4,
            cornerShape = uiState.selectedShapeValue.dp,
            isPassword = uiState.isPassword,
            containerHeight = uiState.containerHeight.dp,
            isError = uiState.isError,
            onOtpTextChange = viewModel::filledValue,
            onCompletedNumbers = viewModel::onCloseKeyboard,
        )

        Card(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(start = 16.dp, end = 16.dp, top = 62.dp)
        ) {
            Column {
                Text(
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                    text = stringResource(R.string.shapes),
                    style = MaterialTheme.typography.displaySmall
                )

                ChooserItem(
                    text = ShapesOptions.Rounded.option,
                    selected = ShapesOptions.Rounded.option == uiState.selectedShape,
                    onClick = {
                        viewModel.onSelectShape(ShapesOptions.Rounded.option)
                    }
                )

                ChooserItem(
                    text = ShapesOptions.Circle.option,
                    selected = ShapesOptions.Circle.option == uiState.selectedShape,
                    onClick = {
                        viewModel.onSelectShape(ShapesOptions.Circle.option)
                    }
                )

                ChooserItem(
                    text = ShapesOptions.Rectangular.option,
                    selected = ShapesOptions.Rectangular.option == uiState.selectedShape,
                    onClick = {
                        viewModel.onSelectShape(ShapesOptions.Rectangular.option)
                    }
                )

            }
        }

        Card(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Column {
                Text(
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                    text = stringResource(R.string.states),
                    style = MaterialTheme.typography.displaySmall
                )

                ChooserItem(
                    text = stringResource(R.string.when_an_otp_specified),
                    selected = StatesOptions.Number.option == uiState.selectedState,
                    onClick = {
                        viewModel.onSelectState(StatesOptions.Number.option)
                    }
                )

                ChooserItem(
                    text = stringResource(R.string.when_an_password_specified),
                    selected = StatesOptions.Secret.option == uiState.selectedState,
                    onClick = {
                        viewModel.onSelectState(StatesOptions.Secret.option)
                    }
                )


                ChooserItem(
                    text = stringResource(R.string.when_an_error_occurs),
                    selected = StatesOptions.Error.option == uiState.selectedState,
                    onClick = {
                        viewModel.onSelectState(StatesOptions.Error.option)
                    }
                )

            }
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun VerifySwiftLightPreview() {
    VerifySwiftTheme {
        SampleScreen()
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun VerifySwiftDarkPreview() {
    VerifySwiftTheme {
        SampleScreen()
    }
}