package com.droidDevOs.verifyswift

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidDevOs.verifyswift.theme.DevOsTheme
import com.droidDevOs.verifyswift.theme.Gray4d4
import com.droidDevOs.verifyswift.theme.RedDE

@Composable
fun MyOtpView(
    otpValue: String,
    isError: Boolean = false,
    onOtpTextChange: (String) -> Unit,
    onCompletedNumbers: () -> Unit,
) {
    EditOtpView(
        otpText = otpValue,
        onOtpTextChange = { onOtpTextChange(it) },
        type = OTP_VIEW_TYPE_BORDER,
        containerHeight = 73.dp,
        containerWidth = 62.dp,
        charSize = 28.sp,
        containerSpace = 8.dp,
        charColor = if (isError) RedDE else Gray4d4,
        onCompletedNumbers = onCompletedNumbers
    )
}

@Preview(showBackground = true)
@Composable
fun OtpViewPreview() {
    DevOsTheme {

        MyOtpView(
            "", onCompletedNumbers = {},
            onOtpTextChange = {}
        )
    }
}