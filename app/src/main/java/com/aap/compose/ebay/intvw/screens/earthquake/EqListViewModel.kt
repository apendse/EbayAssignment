package com.aap.compose.ebay.intvw.screens.earthquake

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
class EqListViewModel @Inject constructor(private val genericRepository: GenericRepository): ViewModel() {

    private val _earthquakes = MutableLiveData<GenericResponse>()

    val earthquakes: LiveData<GenericResponse>
        get() = _earthquakes

    fun fetchEarthquakeList(isForced: Boolean) {
        if (!isForced && _earthquakes.value is GenericResponse.GenericSuccess) {
            return
        }
        viewModelScope.launch {
            _earthquakes.postValue(genericRepository.fetchEarthquakeList())
        }
    }
}