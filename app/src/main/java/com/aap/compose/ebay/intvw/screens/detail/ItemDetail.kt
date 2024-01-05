package com.aap.compose.ebay.intvw.screens.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.aap.compose.ebay.intvw.data.EqDataVO

@Composable
fun EarthquakeDetail(index: Int, viewModel: ItemDetailViewModel = hiltViewModel()) {
    val dataEntity = viewModel.earthquake.observeAsState()
    LaunchedEffect(key1 = Unit) {
        viewModel.fetchEarthquake(index)
    }
    dataEntity.value?.let {
        ShowEarthquake(it)
    }
}

@Composable
fun ShowEarthquake(eqDataVO: EqDataVO) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = eqDataVO.eqId)
        Text(text = eqDataVO.dateTime)
        Text(text = "${eqDataVO.magnitude}")
    }
}