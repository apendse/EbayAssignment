package com.aap.compose.ebay.intvw.screens.earthquake

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aap.compose.ebay.intvw.data.EqDataVO
import com.aap.compose.ebay.intvw.repo.GenericResponse

@Composable
fun EqList(onRowClick: (Int) -> Unit, viewModel: EqListViewModel = hiltViewModel()) {
    val earthquakes = viewModel.earthquakes.observeAsState()
    LaunchedEffect(key1 = Unit) {
        viewModel.fetchEarthquakeList(false)
    }
    when (earthquakes.value) {
        is GenericResponse.GenericError -> {
            showError()
        }
        is GenericResponse.GenericSuccess -> {
            ShowEarthquakeList(onRowClick, (earthquakes.value as GenericResponse.GenericSuccess).earthquakes)
        }
        null -> showError()
    }
}

@Composable
fun ShowEarthquakeList(onRowClick: (Int) -> Unit, list: List<EqDataVO>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        this.itemsIndexed(list, key = { _, earthquake -> earthquake.eqId }) { index, earthquake ->
            RenderRow(onRowClick, index, earthquake)
        }
    }
}

@Composable
fun RenderRow(onRowClick: (Int) -> Unit, index: Int, earthquake: EqDataVO) {

    Column(modifier = Modifier.clickable {
        onRowClick(index)
    }) {
        Text(earthquake.eqId)

        Text("${earthquake.magnitude}")

        Divider(modifier = Modifier.fillMaxWidth(), thickness = 4.dp, color = Color.LightGray)

    }

}

@Composable
fun showError() {

}