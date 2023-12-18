package com.example.verifyswift.anim

import androidx.compose.runtime.Composable

internal data class CircularRevealAnimationItem<T>(
    val key: T,
    val content: @Composable () -> Unit
)
