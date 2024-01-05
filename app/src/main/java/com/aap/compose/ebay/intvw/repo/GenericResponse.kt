package com.aap.compose.ebay.intvw.repo

import com.aap.compose.ebay.intvw.data.EqDataVO
import com.aap.compose.ebay.intvw.data.GenericDataVO


sealed class GenericResponse {

    class GenericSuccess(val earthquakes: List<EqDataVO>): GenericResponse()

    class GenericError(val throwable: Throwable? = null, val message: String = ""): GenericResponse()

}