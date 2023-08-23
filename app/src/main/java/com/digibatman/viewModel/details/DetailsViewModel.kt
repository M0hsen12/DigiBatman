package com.digibatman.viewModel.details

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.digibatman.di.database.details.DetailsDAO
import com.digibatman.di.network.ApiServices
import com.digibatman.model.details.Details
import com.digibatman.ui.general.MyApplication
import com.digibatman.util.detailEntityToDetails
import com.digibatman.util.isOnline
import com.digibatman.util.movieDetailToEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val apiServices: ApiServices,
    private val detailsDao: DetailsDAO,
    private val context: MyApplication
) : ViewModel() {


    val showProgressBar: StateFlow<Boolean> get() = _showProgressBar
    private val _showProgressBar = MutableStateFlow(true)

    private val _movieDetails = MutableStateFlow(Details())
    val movieDetails: StateFlow<Details> get() = _movieDetails

    val errorMessage = MutableLiveData<String>()

    var job: Job? = null

    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e("eee", "on exepetion $throwable:")
        errorMessage.value = throwable.message
    }


    fun getMovieDetails(imdbId: String) {
        if (isOnline(context.applicationContext))
            getDetailsMovieWithApiCall(imdbId)
        else
            getMoviesDetailsFromDatabase(imdbId)


    }

    private fun getMoviesDetailsFromDatabase(imdbId: String) {
        job = viewModelScope.launch(exceptionHandler) {
            val details = detailsDao.findMovieDetails(imdbId)
            if (details.detailImdbId.isNotEmpty()) {
                _movieDetails.value = detailEntityToDetails(details)
                _showProgressBar.value = false

            }

        }

    }

    private fun getDetailsMovieWithApiCall(imdbId: String) {
        job = viewModelScope.launch(exceptionHandler) {
            val response = apiServices.getDetails(imdbId)
            if (response.isSuccessful) {
                _movieDetails.value = response.body() ?: Details()
                _showProgressBar.value = false
                saveTheResponse(response.body())
            } else {
                errorMessage.value = response.message()
            }
        }
    }

    private fun saveTheResponse(details: Details?) {
        viewModelScope.launch(exceptionHandler) {
            detailsDao.addDetails( // if there is conflict it will be replaced too
                movieDetailToEntity(details ?: Details())
            )
        }
    }


    override fun onCleared() {
        super.onCleared()
        job?.takeIf { it.isActive }?.cancel()
    }
}