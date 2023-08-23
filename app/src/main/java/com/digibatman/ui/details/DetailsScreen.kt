package com.digibatman.ui.details

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.digibatman.ui.composable.reusables.DisplayProgressbar
import com.digibatman.viewModel.details.DetailsViewModel

@Composable
fun DetailScreen(navController: NavHostController, viewModel: DetailsViewModel) {
    val imdbID = navController.previousBackStackEntry?.savedStateHandle?.get<String>(
        ""
    )
    val shouldShowDialog = viewModel.showProgressBar.collectAsState()
    if (shouldShowDialog.value)
        DisplayProgressbar(state = shouldShowDialog)

    LaunchedEffect(key1 = viewModel) {
        viewModel.getCapeCrusaderMovies()

    }
    val movies = viewModel.movies.collectAsState()

    Log.e("TAG", "DetailScreen: $imdbID")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
//        AsyncImage(
//            modifier = Modifier.fillMaxWidth(),
//            model = movie?.poster ?: "",
//            contentDescription = null,
//            contentScale = ContentScale.Crop,
//        )
    }
}