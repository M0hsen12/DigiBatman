package com.digibatman.ui.details

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import com.digibatman.ui.composable.details.DetailsView
import com.digibatman.ui.composable.reusables.DisplayProgressbar
import com.digibatman.util.ArgItemKey
import com.digibatman.viewModel.details.DetailsViewModel

@Composable
fun DetailScreen(navController: NavHostController, viewModel: DetailsViewModel) {

    val shouldShowDialog = viewModel.showProgressBar.collectAsState()
    if (shouldShowDialog.value)
        DisplayProgressbar(state = shouldShowDialog)

    LaunchedEffect(key1 = viewModel) {
        val imdbID = navController.previousBackStackEntry?.savedStateHandle?.get<String>(ArgItemKey)
        viewModel.getMovieDetails(imdbID ?: "")
    }

    val movieDetailsState = viewModel.movieDetails.collectAsState()

    if (movieDetailsState.value.isOkToContinue() == true) {
        Log.e("eee", "DetailScreen: shet is not null")
        DetailsView(movieDetailsState)
    }

}