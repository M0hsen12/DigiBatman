package com.digibatman.viewModel.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
//    private val retro: ApiServices,
) : ViewModel() {


    val showProgressBar: StateFlow<Boolean> get() = _showProgressBar
    private val _showProgressBar = MutableStateFlow(true)

    private val itemIdsList = MutableStateFlow(listOf<String>())
    val itemIds: StateFlow<List<String>> get() = itemIdsList

//
//    private val searchHistoryList = MutableStateFlow(listOf<SearchHistoryEntity>())
//    val historyList: StateFlow<List<SearchHistoryEntity>> get() = searchHistoryList
//
//    private val _favoritesList = MutableStateFlow(listOf<FavoriteCurrencyEntity>())
//    val favoritesList: StateFlow<List<FavoriteCurrencyEntity>> get() = _favoritesList
//
//    private val _coinList = MutableStateFlow(Coins())
//    val coinList: StateFlow<Coins> get() = _coinList
//
//    var savedCoins: Coins? = null

    val errorMessage = MutableLiveData<String>()
    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e("qqq", "on exepetion $throwable:")
        errorMessage.value = throwable.message
    }


    fun getAllCoins() {
//        Log.e("TAG", "getAllCoins:1213 ${job?.isActive}")
//        job = viewModelScope.launch(exceptionHandler) {
//            val response = retro.getAllCoins()
//            if (response.isSuccessful) {
//                _coinList.value = response.body()!!
//                savedCoins = response.body()
//                _showProgressBar.value = false
//            } else {
//                errorMessage.value = response.message()
//            }
//        }
    }


}