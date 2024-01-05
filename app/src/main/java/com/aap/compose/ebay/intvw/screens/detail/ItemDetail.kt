package com.aap.compose.ebay.intvw.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.aap.compose.ebay.intvw.R
import com.aap.compose.ebay.intvw.data.EqDataVO
import com.aap.compose.ebay.intvw.ui.theme.DetailBackground

@Composable
fun EarthquakeDetail(index: Int, viewModel: ItemDetailViewModel = hiltViewModel()) {
    val dataEntity = viewModel.earthquake.observeAsState()
    LaunchedEffect(key1 = Unit) {
        viewModel.fetchEarthquake(index)
    }
    dataEntity.value?.let {
        showEarthquake(it)
    }
}

@Composable
fun showEarthquake(eqDataVO: EqDataVO) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = eqDataVO.eqId)
        Text(text = eqDataVO.dateTime)
        Text(text = "${eqDataVO.magnitude}")
    }
}