package com.digibatman.ui.composable.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.digibatman.model.movie.BatmanMovies
import com.digibatman.ui.theme.HomeItemGradient
import com.digibatman.util.HomeItemsCellCount
import com.digibatman.util.HomeItemsHeight
import com.digibatman.util.HomeItemsShadowHeight
import com.digibatman.util.getHeightOfScreen

@Composable
fun SetupHomeList(value: BatmanMovies, onItemClick: (imdbId: String) -> Unit) {
    LazyVerticalGrid(columns = GridCells.Fixed(HomeItemsCellCount), content = {
        items(value.search.orEmpty().size) { index ->
            val movie = value.search.orEmpty()[index]
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = getHeightOfScreen().div(HomeItemsHeight).dp)
                    .padding(0.5.dp)
                    .background(color = Color.Red)
                    .clickable {
                        onItemClick.invoke(movie?.imdbID ?: "")
                    },
                contentAlignment = Alignment.BottomCenter
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxWidth(),
                    model = movie?.poster ?: "",
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(getHeightOfScreen().div(HomeItemsShadowHeight).dp)
                        .background(HomeItemGradient),
                    verticalArrangement = Arrangement.Bottom
                ) {

                    Text(
                        modifier = Modifier.padding(
                            start = 6.dp,
                            top = 0.dp,
                            end = 0.dp,
                            bottom = 2.dp
                        ),
                        text = "${movie?.title ?: ""} - ${movie?.year ?: ""}"
                    )
                    Text(
                        modifier = Modifier.padding(
                            start = 6.dp,
                            top = 0.dp,
                            end = 0.dp,
                            bottom = 6.dp
                        ), text = movie?.type ?: ""
                    )
                }

            }
        }
    })

}