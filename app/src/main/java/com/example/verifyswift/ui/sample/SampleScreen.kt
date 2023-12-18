package com.example.verifyswift.ui.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.droidDevOs.verifyswift.MyOtpView
import com.example.verifyswift.theme.VerifySwiftTheme


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
            .padding(innerPadding)
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyOtpView(
            otpValue = uiState.otp,
            isError = false,
            onOtpTextChange = viewModel::filledValue,
            onCompletedNumbers = viewModel::onCloseKeyboard,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyLibPreview() {
    VerifySwiftTheme {
        SampleScreen()
    }
}