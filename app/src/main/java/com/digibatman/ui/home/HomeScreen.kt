package com.digibatman.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.digibatman.ui.composable.home.SetupHomeList
import com.digibatman.ui.composable.reusables.DisplayProgressbar
import com.digibatman.util.Screens
import com.digibatman.viewModel.home.HomeViewModel

@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel) {
    val shouldShowDialog = viewModel.showProgressBar.collectAsState()
    if (shouldShowDialog.value)
        DisplayProgressbar(state = shouldShowDialog)

    LaunchedEffect(key1 = viewModel) {
        viewModel.getCapeCrusaderMovies()

    }
    val movies = viewModel.movies.collectAsState()

    Column(Modifier.fillMaxSize()) {

        if (movies.value.search?.isNotEmpty() == true)
            SetupHomeList(value = movies.value, onItemClick = {
                navController.currentBackStackEntry?.savedStateHandle?.apply {
                    set("ImdbId", it)
                }
                navController.navigate(Screens.Details.route)
            })
    }
}


