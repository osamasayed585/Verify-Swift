package com.example.verifyswift.ui.sample

import com.example.verifyswift.base.BaseViewModel
import com.example.verifyswift.ui.sample.event.SampleEvent
import com.example.verifyswift.ui.sample.state.SampleState


class SampleViewModel : BaseViewModel<SampleState, SampleEvent>(SampleState()) {
    override fun reduce(oldState: SampleState, sideEffect: SampleEvent) {

        when (sideEffect) {
            is SampleEvent.OnValueFilled -> {
                createNewState(
                    oldState.copy(
                        otp = sideEffect.option,
                        isCloseKeyboard = sideEffect.option.length == 4
                    )
                )
            }

            is SampleEvent.OnSelectShape -> {
                createNewState(
                    oldState.copy(
                        selectedShape = sideEffect.option
                    )
                )
            }

            is SampleEvent.OnSelectState -> {
                createNewState(
                    oldState.copy(
                        selectedState = sideEffect.option
                    )
                )
            }

            is SampleEvent.OnCloseKeyboard -> {
                createNewState(
                    oldState.copy(
                        isCloseKeyboard = sideEffect.state
                    )
                )
            }
        }
    }

    fun filledValue(newValue: String) {
        emitEvent(SampleEvent.OnValueFilled(newValue))
    }

    fun onCloseKeyboard() {
        emitEvent(
            SampleEvent.OnCloseKeyboard(uiState.value.otp.length == 4)
        )
    }
}