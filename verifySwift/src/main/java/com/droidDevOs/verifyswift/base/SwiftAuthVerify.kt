package com.droidDevOs.verifyswift.base

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidDevOs.verifyswift.theme.DevOsTheme

enum class PinViewType {
    UNDERLINE,
    BORDER
}

@Composable
fun VerifySwift(
    modifier: Modifier,
    otpText: String,
    charColor: Color,
    charBackground: Color,
    charSize: TextUnit,
    containerSpace: Dp,
    cornerShape: Dp,
    containerHeight: Dp,
    containerWidth: Dp,
    pinCount: Int,
    type: PinViewType,
    enabled: Boolean,
    password: Boolean,
    passwordChar: String = "▪",
    onCompletedNumbers: () -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Number,
        imeAction = ImeAction.Done
    ),
    onOtpTextChange: (String) -> Unit
) {
    BasicTextField(
        modifier = modifier,
        value = otpText,
        onValueChange = {
            if (it.length <= pinCount) {
                onOtpTextChange.invoke(it)
                if (it.length == 4) onCompletedNumbers()
            }
        },
        enabled = enabled,
        keyboardOptions = keyboardOptions,
        decorationBox = {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                Row(horizontalArrangement = Arrangement.SpaceAround) {
                    repeat(pinCount) { index ->
                        Spacer(modifier = Modifier.width(containerSpace))
                        CharView(
                            index = index,
                            text = otpText,
                            charColor = charColor,
                            charSize = charSize,
                            containerHeight = containerHeight,
                            containerWidth = containerWidth,
                            cornerShape = cornerShape,
                            type = type,
                            charBackground = charBackground,
                            password = password,
                            passwordChar = passwordChar
                        )
                        Spacer(modifier = Modifier.width(containerSpace))
                    }
                }
            }
        }
    )
}


@Composable
private

fun CharView(
    index: Int,
    text: String,
    charColor: Color,
    charSize: TextUnit,
    containerHeight: Dp,
    containerWidth: Dp,
    cornerShape: Dp,
    type: PinViewType,
    charBackground: Color = Color.Transparent,
    password: Boolean = false,
    passwordChar: String
) {
    val modifier = if (type == PinViewType.BORDER) {
        Modifier
            .height(containerHeight)
            .width(containerWidth)
            .border(
                width = 1.dp,
                color = charColor,
                shape = RoundedCornerShape(cornerShape)
            )
            .background(charBackground)
    } else Modifier
        .width(containerWidth)
        .background(charBackground)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        val char = when {
            index >= text.length -> ""
            password -> passwordChar
            else -> text[index].toString()
        }
        Text(
            text = char,
            color = charColor,
            modifier = modifier.wrapContentHeight(),
            fontSize = charSize,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium
        )
        if (type == PinViewType.UNDERLINE) {
            Spacer(modifier = Modifier.height(2.dp))
            Box(
                modifier = Modifier
                    .background(charColor)
                    .height(1.dp)
                    .width(containerWidth)
            )
        }
    }
}

/**
 * A composable function representing an OTP input view in SwiftAuth.
 *
 * @param modifier: [Modifier] to customize the appearance and behavior of the SwiftAuth composable.
 *                 Default sets the background color to match MaterialTheme's background color.
 * @param otpValue: The current OTP (One-Time Password) value entered by the user.
 * @param onOtpTextChange: Callback function invoked when the OTP text changes. Takes the updated OTP string as a parameter.
 * @param onCompletedNumbers: Callback function triggered when the user completes entering the OTP, specified Unit.
 * @param isError: Boolean flag indicating whether an error state should be displayed.
 * @param isPassword: Boolean flag indicating whether it is visible or not.
 * @param enabled: Boolean flag indicating whether it is enabled or disabled.
 * @param pinCount: Number of digits in the OTP. Default is 4.
 * @param containerHeight: Height of the container holding the OTP input, specified in Density-independent Pixels (Dp).
 * @param containerWidth: Width of the container holding the OTP input, specified in Density-independent Pixels (Dp).
 * @param charSize: Font size of each character in the OTP input, specified in TextUnits.
 * @param containerSpace: Space between individual characters in the OTP input, specified in Density-independent Pixels (Dp).
 * @param cornerShape: Corner radius of the container holding the OTP input, specified in Density-independent Pixels (Dp).
 * @param outLineChar: Enum representing the type of pin view (BORDER, UNDERLINE).
 * @param charErrorColor: Color used to indicate errors in the OTP input.
 * @param charNormalColor: Normal color of characters in the OTP input.
 * @param charBackground: Background color of characters in the OTP input.
 */
@Composable
fun SwiftAuth(
    modifier: Modifier = Modifier.background(MaterialTheme.colorScheme.background),
    otpValue: String,
    onOtpTextChange: (String) -> Unit,
    onCompletedNumbers: (pinCount: Int) -> Unit = {},
    isError: Boolean = false,
    isPassword: Boolean = false,
    enabled: Boolean = true,
    pinCount: Int = 4,
    containerHeight: Dp = 70.dp,
    containerWidth: Dp = 60.dp,
    charSize: TextUnit = 28.sp,
    containerSpace: Dp = 6.dp,
    cornerShape: Dp = 16.dp,
    outLineChar: PinViewType = PinViewType.BORDER,
    charErrorColor: Color = MaterialTheme.colorScheme.error,
    charNormalColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    charBackground: Color = Color.Transparent,
) {
    VerifySwift(
        modifier = modifier,
        otpText = otpValue,
        onOtpTextChange = { onOtpTextChange(it) },
        type = outLineChar,
        containerHeight = containerHeight,
        containerWidth = containerWidth,
        pinCount = pinCount,
        charSize = charSize,
        charColor = if (isError) charErrorColor else charNormalColor,
        onCompletedNumbers = { onCompletedNumbers(pinCount) },
        charBackground = charBackground,
        containerSpace = containerSpace,
        cornerShape = cornerShape,
        password = isPassword,
        enabled = enabled
    )
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun OtpViewPreview() {
    DevOsTheme {
        SwiftAuth(
            otpValue = "23",
            onCompletedNumbers = {},
            onOtpTextChange = {},
            isError = true
        )
    }
}


@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun OtpViewLightPreview() {
    DevOsTheme {
        SwiftAuth(
            otpValue = "343",
            onCompletedNumbers = {},
            onOtpTextChange = {},
            isError = true,
        )
    }
}