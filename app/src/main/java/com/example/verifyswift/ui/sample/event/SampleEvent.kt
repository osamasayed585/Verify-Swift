package com.example.verifyswift.ui.sample.event

import com.example.verifyswift.base.ScreenEvent

sealed class SampleEvent : ScreenEvent {
    data class OnSelectShape(val option: String) : SampleEvent()
    data class OnSelectState(val option: String) : SampleEvent()
    data class OnValueFilled(val option: String) : SampleEvent()
    data class OnCloseKeyboard(val state: Boolean) : SampleEvent()
}