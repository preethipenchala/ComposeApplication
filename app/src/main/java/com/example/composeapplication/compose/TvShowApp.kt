package com.example.composeapplication.compose

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.composeapplication.modal.TvShowlist

@Composable
fun TvShowApp(
    windowWidthSizeClass: WindowWidthSizeClass,
    displayTvShowScreen: @Composable (selectedItem: (TvShowlist) -> Unit) -> Unit
) {
    val (currentScreen, setCurrentScreen) = remember { mutableStateOf<TvShowlist?>(null) }

    if (currentScreen == null) {
        displayTvShowScreen { tvShow ->
            setCurrentScreen(tvShow)
        }
    } else {
        InfoScreen(
            tvShow = currentScreen,
            windowWidthSizeClass = windowWidthSizeClass,
            onBack = { setCurrentScreen(null) }
        )
    }
}
