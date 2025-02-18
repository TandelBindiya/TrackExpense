package com.vedis.trackexpense.presentation.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.vedis.trackexpense.ui.theme.AppTheme

class MainViewModel : ViewModel() {

    var appState by mutableStateOf(MainState())

    fun onEvent(event: MainEvent) {
        when (event) {
            is MainEvent.ThemeChange -> {
                changeTheme()
            }
        }
    }

    private fun changeTheme() {
        appState =
            appState.copy(
                appTheme =
                    if (appState.appTheme == AppTheme.LIGHT) AppTheme.DARK else AppTheme.LIGHT
            )
    }
}

sealed class MainEvent {
    object ThemeChange : MainEvent()
}

data class MainState(var appTheme: AppTheme = AppTheme.DEFAULT)
