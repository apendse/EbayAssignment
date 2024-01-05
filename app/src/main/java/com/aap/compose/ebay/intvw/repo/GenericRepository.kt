package com.aap.compose.ebay.intvw.repo

import com.aap.compose.ebay.intvw.data.EqDataVO


interface GenericRepository {
    suspend fun fetchEarthquakeList(): GenericResponse
    fun getEarthquake(index: Int): EqDataVO?
}