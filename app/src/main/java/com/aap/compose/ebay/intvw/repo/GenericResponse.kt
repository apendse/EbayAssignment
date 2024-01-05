package com.aap.compose.ebay.intvw.repo

import com.aap.compose.ebay.intvw.data.EqDataVO


sealed class GenericResponse {

    class GenericSuccess(val earthquakes: List<EqDataVO>): GenericResponse()

    class GenericError(val throwable: Throwable? = null, val message: String = ""): GenericResponse()

}