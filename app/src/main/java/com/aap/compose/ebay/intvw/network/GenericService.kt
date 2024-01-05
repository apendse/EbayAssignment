package com.aap.compose.ebay.intvw.network

import com.aap.compose.ebay.intvw.data.MemeDataResponseVO
import retrofit2.http.GET

interface GenericService {

    @GET("get_memes")
    suspend fun getTopMemes(): MemeDataResponseVO
}