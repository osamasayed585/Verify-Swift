package com.example.verifyswift.ui.sample

import com.example.verifyswift.base.BaseViewModel
import com.example.verifyswift.ui.sample.event.SampleEvent
import com.example.verifyswift.ui.sample.state.SampleState
import com.example.verifyswift.ui.sample.state.ShapesOptions
import com.example.verifyswift.ui.sample.state.StatesOptions


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
                        selectedShape = sideEffect.option,
                        selectedShapeValue = ShapesOptions.getShapeValue(sideEffect.option),
                        containerHeight = ShapesOptions.getContainerHeight(sideEffect.option),
                    )
                )
            }

            is SampleEvent.OnSelectState -> {
                createNewState(
                    oldState.copy(
                        selectedState = sideEffect.option,
                        isPassword = sideEffect.option == StatesOptions.Secret.option,
                        isError = sideEffect.option == StatesOptions.Error.option,
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

    fun onCloseKeyboard(count: Int) {
        emitEvent(
            SampleEvent.OnCloseKeyboard(uiState.value.otp.length == count)
        )
    }

    fun onSelectState(state: String) {
        emitEvent(SampleEvent.OnSelectState(state))
    }

    fun onSelectShape(shape: String) {
        emitEvent(SampleEvent.OnSelectShape(shape))
    }
}