package com.example.composeapplication.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.composeapplication.modal.TvShowlist

@Composable
fun InfoScreen(tvShow: TvShowlist, windowWidthSizeClass: WindowWidthSizeClass, onBack: () -> Unit) {
    if (windowWidthSizeClass == WindowWidthSizeClass.Compact) {
        // Portrait - Phone Layout
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TvShowImage(tvShow = tvShow, contentScale = ContentScale.Fit)
            Spacer(modifier = Modifier.height(16.dp))
            TvShowDetails(tvShow)
            Spacer(modifier = Modifier.height(24.dp))
            BackButton(onBack)
        }
    } else {
        // Tablet - Landscape Layout
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top
        ) {
            TvShowImage(tvShow = tvShow, contentScale = ContentScale.Fit)
            Spacer(modifier = Modifier.width(24.dp))
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                TvShowDetails(tvShow)
                Spacer(modifier = Modifier.height(24.dp))
                BackButton(onBack)
            }
        }
    }
}

@Composable
fun TvShowDetails(tvShow: TvShowlist) {
    Text(
        text = tvShow.name,
        style = MaterialTheme.typography.headlineLarge
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = "${tvShow.year} | Rating: ${tvShow.rating}",
        style = MaterialTheme.typography.headlineMedium
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = tvShow.description,
        style = MaterialTheme.typography.headlineSmall
    )
}

@Composable
fun BackButton(onBack: () -> Unit) {
    Button(onClick = onBack, modifier = Modifier.width(160.dp).height(100.dp)) {
        Text(text = "Back", style = MaterialTheme.typography.headlineMedium)
    }
}
