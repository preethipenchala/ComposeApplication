package com.example.composeapplication.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.composeapplication.modal.TvShowlist

@Composable
fun TvShowApp(displayTvShowScreen: @Composable (selectedItem: (TvShowlist) -> Unit) -> Unit) {
    val (currentScreen, setCurrentScreen) = remember { mutableStateOf<TvShowlist?>(null) }

    if (currentScreen == null) {
        displayTvShowScreen { tvShow ->
            setCurrentScreen(tvShow)
        }
    } else {
        InfoScreen(tvShow = currentScreen, onBack = {
            setCurrentScreen(null)
        })
    }
}
