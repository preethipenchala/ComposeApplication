package com.example.composeapplication.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.composeapplication.modal.TvShowlist

@Composable
fun TvScreenListItem(tvShow: TvShowlist, selectedItem: (TvShowlist) -> Unit){
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(10.dp)) {
        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .clickable { selectedItem(tvShow) },
            verticalAlignment = Alignment.CenterVertically
            ) {
            TvShowImage(tvShow, ContentScale.Crop)
            Spacer(Modifier.width(5.dp))
            Column {
                Text(
                    text = tvShow.name,
                    style = MaterialTheme.typography.headlineLarge)
                Spacer(Modifier.height(5.dp))
                Text(
                    text = tvShow.description,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis)
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = tvShow.year.toString(),
                        style = MaterialTheme.typography.headlineSmall)
                    Text(
                        text = tvShow.rating.toString(),
                        style = MaterialTheme.typography.headlineSmall)

                }
            }
        }

    }

}

@Composable
fun TvShowImage(tvShow: TvShowlist, contentScale: ContentScale) {
    AsyncImage(
        model = tvShow.imageUrl,
        contentDescription = "${tvShow.name} image",
        modifier = Modifier.padding(4.dp)
            .height(140.dp).width(100.dp)
            .clip(RoundedCornerShape(10.dp)),
        contentScale = contentScale
    )
}