package com.aap.compose.ebay.intvw.screens.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aap.compose.ebay.intvw.repo.GenericRepository
import com.aap.compose.ebay.intvw.repo.GenericResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemListViewModel @Inject constructor(private val genericRepository: GenericRepository): ViewModel() {

    private val _memes = MutableLiveData<GenericResponse>()

    val memes: LiveData<GenericResponse>
        get() = _memes


    fun fetchTopMemes() {
        viewModelScope.launch {
            Log.d("YYYY", "VM: before postValue")
            //_memes.postValue(genericRepository.fetchDataList())
        }
    }

    val deleteMeme : (idx: Int) -> Unit = { index ->
        viewModelScope.launch {
            //_memes.postValue(genericRepository.removeMeme(index))
        }
    }
}