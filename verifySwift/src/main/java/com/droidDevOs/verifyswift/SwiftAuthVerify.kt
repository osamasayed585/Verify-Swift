package com.droidDevOs.verifyswift

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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


const val OTP_VIEW_TYPE_UNDERLINE = 1
const val OTP_VIEW_TYPE_BORDER = 2

@Composable
fun EditOtpView(
    modifier: Modifier = Modifier,
    otpText: String = "",
    charColor: Color = Color.Black,
    charBackground: Color = Color.Transparent,
    charSize: TextUnit = 16.sp,
    containerSpace: Dp = 2.dp,
    cornerShape: Dp = 16.dp,
    containerHeight: Dp = 70.dp,
    containerWidth: Dp = 60.dp,
    otpCount: Int = 4,
    type: Int = OTP_VIEW_TYPE_UNDERLINE,
    enabled: Boolean = true,
    password: Boolean = false,
    passwordChar: String = "",
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
            if (it.length <= otpCount) {
                onOtpTextChange.invoke(it)
                if (it.length == 4) onCompletedNumbers()
            }
        },
        enabled = enabled,
        keyboardOptions = keyboardOptions,
        decorationBox = {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                Row(horizontalArrangement = Arrangement.SpaceAround) {
                    repeat(otpCount) { index ->
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
    type: Int = OTP_VIEW_TYPE_UNDERLINE,
    charBackground: Color = Color.Transparent,
    password: Boolean = false,
    passwordChar: String = ""
) {
    val modifier = if (type == OTP_VIEW_TYPE_BORDER) {
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
//            fontFamily = Teshrin,
            fontWeight = FontWeight.Medium
        )
        if (type == OTP_VIEW_TYPE_UNDERLINE) {
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