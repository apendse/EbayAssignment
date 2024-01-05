package com.aap.compose.ebay.intvw.screens.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aap.compose.ebay.intvw.data.EqDataVO
import com.aap.compose.ebay.intvw.repo.GenericRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemDetailViewModel @Inject constructor(private val genericRepository: GenericRepository): ViewModel() {
    val _eq = MutableLiveData<EqDataVO>()

    val earthquake: LiveData<EqDataVO>
        get() = _eq

    fun fetchEarthquake(index: Int) {
        genericRepository.getEarthquake(index)?.let {
            _eq.postValue(it)
        }
//        val meme = genericRepository.getMeme(index) ?: return
//        _meme.value = meme
    }
}