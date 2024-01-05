package com.aap.compose.ebay.intvw.network

import com.aap.compose.ebay.intvw.data.EqDataContainerVO
import retrofit2.http.GET
import retrofit2.http.Query

// http://api.geonames.org/earthquakesJSON?formatted=true&north=44.1&south=-9.9&east=-22.4&west=55.2&username=mkoppelman

interface EqService {
    @GET("earthquakesJSON")
    suspend fun getEarthquakeList(@Query("formatted") formatted: Boolean = true,  @Query("north") north: Double = 44.1,
                                    @Query("south") south: Double = -9.9, @Query("east") east: Double = -22.4,
                                  @Query("west") west: Double = 55.2,
                                    @Query("username") userName: String = "mkoppelman"

                                    ): EqDataContainerVO
}