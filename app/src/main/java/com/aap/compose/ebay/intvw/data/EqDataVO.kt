package com.aap.compose.ebay.intvw.data

import com.google.gson.annotations.SerializedName

data class EqDataContainerVO(val earthquakes: List<EqDataVO>)
data class EqDataVO(@SerializedName("datetime") val dateTime: String, val depth: Double,
                    @SerializedName("lng") val longitude: Double,
                    @SerializedName("lat") val latitude: Double, val src: String,
                    @SerializedName("eqid") val eqId: String, val magnitude: Double)
