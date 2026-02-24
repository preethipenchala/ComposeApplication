package com.example.composeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composeapplication.compose.TvScreenListItem
import com.example.composeapplication.compose.TvShowApp
import com.example.composeapplication.data.TvShowMockData
import com.example.composeapplication.modal.TvShowlist
import com.example.composeapplication.ui.theme.ComposeApplicationTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TvShowApp { selectedItem ->
                        DisplayTvShowScreen(selectedItem = selectedItem)
                    }
                }
            }
        }
    }
}

@Composable
fun DisplayTvShowScreen(selectedItem: (TvShowlist) -> Unit) {
    val tvShows = remember { TvShowMockData.tvShows }
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        items(
            items = tvShows,
            itemContent = { tvShow ->
                TvScreenListItem(tvShow = tvShow, selectedItem = selectedItem)
            }
        )
    }
}

@Composable
fun LazyColumnDemo(selectedItem: (String) -> Unit) {
    val scrollableState = rememberLazyListState()
    LazyColumn(state = scrollableState) {
        items(100) {
            Text(
                text = "Item $it",
                modifier = Modifier.clickable { selectedItem("$it Clicked") }.padding(10.dp)
            )
            Divider(thickness = 5.dp, color = Color.Black)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplaySnackBar() {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Button(
            modifier = Modifier.padding(paddingValues),
            onClick = {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar(
                        "Action Performed",
                        "Undo",
                        duration = SnackbarDuration.Short
                    )
                }
            }
        ) { 
            Text(text = "Show Snackbar")
        }
    }
}
