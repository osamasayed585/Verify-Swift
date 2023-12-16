package com.example.verifyswift.base

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


abstract class BaseViewModel<T : ScreenState, in E : ScreenEvent>(initialVal: T) : ViewModel() {

    private var _uiState = MutableStateFlow(initialVal)
    val uiState: StateFlow<T> get() = _uiState

    fun emitEvent(event: E) {
        reduce(_uiState.value, event)
    }

    fun createNewState(newState: T) {
        _uiState.tryEmit(newState)
    }

    abstract fun reduce(oldState: T, sideEffect: E)
}

interface ScreenState
interface ScreenEvent