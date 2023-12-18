package com.example.verifyswift.ui.sample.state

import com.example.verifyswift.base.ScreenState

data class SampleState(
    val shapes: List<String> = ShapesOptions.getOptions(),
    val states: List<String> = StatesOptions.getOptions(),
    val selectedShape: String = ShapesOptions.getOptions().first(),
    val selectedState: String = StatesOptions.getOptions().first(),
    val isError: Boolean = false,
    val isPassword: Boolean = false,
    val isCloseKeyboard: Boolean = false,
    val otp: String = "",
) : ScreenState

enum class ShapesOptions(val option: String) {
    Circle("Circle"),
    Rounded("Rounded Corners"),
    Rectangular("Rectangular");

    companion object {
        fun getOptions() = listOf(
            Circle.option,
            Rounded.option,
            Rectangular.option
        )
    }
}

enum class StatesOptions(val option: String) {
    Secret("Secret"),
    Error("Error");

    companion object {
        fun getOptions() = listOf(
            Secret.option,
            Error.option
        )
    }
}