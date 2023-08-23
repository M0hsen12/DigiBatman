package com.digibatman.viewModel.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.digibatman.di.database.movie.MovieDAO
import com.digibatman.di.network.ApiServices
import com.digibatman.model.movie.BatmanMovies
import com.digibatman.model.movie.Search
import com.digibatman.ui.general.MyApplication
import com.digibatman.util.batmanMoviesToEntity
import com.digibatman.util.entityToBatmanMovies
import com.digibatman.util.isOnline
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
    private val movieDAO: MovieDAO,
    private val context: MyApplication
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
        if (isOnline(context.applicationContext))
            getMoviesWithApiCall()
        else
            getMoviesFromDatabase()


    }

    private fun getMoviesFromDatabase() {
        job = viewModelScope.launch(exceptionHandler) {
            val list = ArrayList<Search>()
            movieDAO.getAllMovies().forEach {
                list.add(entityToBatmanMovies(it))
            }

            _movies.value = BatmanMovies(search = list)
            _showProgressBar.value = false

        }

    }

    private fun getMoviesWithApiCall() {
        job = viewModelScope.launch(exceptionHandler) {
            val response = apiServices.getBatmanMovies()
            if (response.isSuccessful) {
                _movies.value = response.body() ?: BatmanMovies()
                _showProgressBar.value = false
                saveTheResponse(response.body())
            } else {
                errorMessage.value = response.message()
            }
        }
    }

    private fun saveTheResponse(movies: BatmanMovies?) {
        viewModelScope.launch(exceptionHandler) {
            movies?.search.orEmpty().forEach {
                movieDAO.addMovie( // if there is conflict it will be replaced
                    batmanMoviesToEntity(
                        it ?: Search()
                    )
                )
            }
            Log.e("TAG", "saveTheResponse: ${movieDAO.getAllMovies().size}")
        }
    }


    override fun onCleared() {
        super.onCleared()
        job?.takeIf { it.isActive }?.cancel()
    }
}