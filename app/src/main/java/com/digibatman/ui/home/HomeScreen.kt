package com.digibatman.ui.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.digibatman.ui.composable.reusables.DisplayProgressbar
import com.digibatman.viewModel.home.HomeViewModel

@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel) {
    val coroutineScope = rememberCoroutineScope()
    val shouldShowDialog = viewModel.showProgressBar.collectAsState()
    if (shouldShowDialog.value)
        DisplayProgressbar(state = shouldShowDialog)

    LaunchedEffect(key1 = viewModel) {
        viewModel.getCapeCrusaderMovies()

    }
    val movies = viewModel.movies.collectAsState()
    Log.e("eee", "HomeScreen: ${movies.value.search?.size}")

    Column(Modifier.fillMaxSize()) {

    }
}