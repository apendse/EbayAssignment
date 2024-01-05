package com.aap.compose.ebay.intvw.data

data class MemeDataResponseVO(val success: Boolean, val data: MemeContainerVO)

data class MemeContainerVO(val memes: List<GenericDataVO>)