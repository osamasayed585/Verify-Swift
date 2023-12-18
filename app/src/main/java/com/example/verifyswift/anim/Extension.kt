package com.example.verifyswift.anim

import androidx.annotation.FloatRange
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import com.sugarspoon.otpview.anim.CircularRevealShape


fun Modifier.circularReveal(
    @FloatRange(from = 0.0, to = 1.0) progress: Float,
    offset: Offset? = null
) = then(
    clip(CircularRevealShape(progress, offset))
)