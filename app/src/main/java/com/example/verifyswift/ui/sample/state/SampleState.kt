package com.example.verifyswift.ui.sample.state

import com.example.verifyswift.base.ScreenState

data class SampleState(
    val shapes: List<String> = ShapesOptions.getOptions(),
    val states: List<String> = StatesOptions.getOptions(),
    val selectedShape: String = ShapesOptions.getOptions().first(),
    val selectedShapeValue: Int = ShapesOptions.getShapeValue(),
    val containerHeight: Int = ShapesOptions.getContainerHeight(),
    val selectedState: String = StatesOptions.getOptions().first(),
    val isError: Boolean = false,
    val isPassword: Boolean = false,
    val isCloseKeyboard: Boolean = false,
    val otp: String = "",
) : ScreenState

enum class ShapesOptions(val option: String) {
    Rounded("Rounded Corners"),
    Circle("Circle"),
    Rectangular("Rectangular");

    companion object {
        fun getOptions() = listOf(
            Rounded.option,
            Circle.option,
            Rectangular.option
        )

        fun getShapeValue(selectedShape: String = Rounded.option): Int =
            when (selectedShape) {
                Circle.option -> 90
                Rounded.option -> 16
                else -> 2
            }

        fun getContainerHeight(selectedShape: String = Rounded.option): Int =
            when (selectedShape) {
                Circle.option -> 60
                else -> 70
            }
    }
}

enum class StatesOptions(val option: String) {
    Number("Number"),
    Secret("Secret"),
    Error("Error");

    companion object {
        fun getOptions() = listOf(
            Number.option,
            Secret.option,
            Error.option
        )
    }
}