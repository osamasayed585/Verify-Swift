package com.example.verifyswift

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.droidDevOs.verifyswift.EditOtpView
import com.droidDevOs.verifyswift.MyOtpView
import com.example.verifyswift.ui.theme.VerifySwiftTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyOtpView(
                otpValue = "",
                isError = false,
                onOtpTextChange = {},
                onCompletedNumbers = {},
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EditOtpViewPreview() {
    VerifySwiftTheme {
        MyOtpView(
            otpValue = "",
            isError = false,
            onOtpTextChange = {},
            onCompletedNumbers = {},
        )
    }
}
