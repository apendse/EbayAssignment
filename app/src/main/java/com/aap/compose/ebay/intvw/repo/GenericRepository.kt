package com.aap.compose.ebay.intvw.repo

import com.aap.compose.ebay.intvw.data.EqDataVO
import com.aap.compose.ebay.intvw.data.GenericDataVO


interface GenericRepository {
    suspend fun fetchEarthquakeList(): GenericResponse
    fun getEarthquake(index: Int): EqDataVO?
}