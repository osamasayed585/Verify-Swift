package com.example.verifyswift

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.droidDevOs.verifyswift.MyOtpView
import com.example.verifyswift.ui.theme.VerifySwiftTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var otp by remember { mutableStateOf("") }
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                MyOtpView(
                    otpValue = otp,
                    isError = false,
                    onOtpTextChange = { otp = it },
                    onCompletedNumbers = {},
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EditOtpViewPreview() {
    VerifySwiftTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            MyOtpView(
                otpValue = "",
                isError = false,
                onOtpTextChange = {},
                onCompletedNumbers = {},
            )
        }
    }
}
