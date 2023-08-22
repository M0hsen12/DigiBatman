package com.digibatman.viewModel.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.digibatman.di.network.ApiServices
import com.digibatman.model.movie.BatmanMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val apiServices: ApiServices,
) : ViewModel() {


    val showProgressBar: StateFlow<Boolean> get() = _showProgressBar
    private val _showProgressBar = MutableStateFlow(true)

    private val _movies = MutableStateFlow(BatmanMovies())
    val movies: StateFlow<BatmanMovies> get() = _movies

    val errorMessage = MutableLiveData<String>()

    var job: Job? = null

    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e("eee", "on exepetion $throwable:")
        errorMessage.value = throwable.message
    }


    fun getCapeCrusaderMovies() {
        job = viewModelScope.launch(exceptionHandler) {
            val response = apiServices.getBatmanMovies()
            if (response.isSuccessful) {
                Log.e("eee", "getCapeCrusaderMovies: ${response.body()?.totalResults}")
                _movies.value = response.body() ?: BatmanMovies()
                _showProgressBar.value = false
            } else {
                errorMessage.value = response.message()
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        job?.takeIf { it.isActive }?.cancel()
    }
}