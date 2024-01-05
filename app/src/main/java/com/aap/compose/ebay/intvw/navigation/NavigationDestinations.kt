package com.aap.compose.ebay.intvw.navigation

object NavigationDestinations {
    const val HOME = "home"
    const val EARTHQUAKE_DETAILS_PREFIX = "eqDetails"
    const val EQ_INDEX = "index"
    const val EARTHQUAKE_DETAILS_PATH = "$EARTHQUAKE_DETAILS_PREFIX/{$EQ_INDEX}"
    const val MEME_DETAIL_PREFIX = "memeDetails"
    const val MEME_INDEX = "index"
    const val MEME_DETAIL = "${MEME_DETAIL_PREFIX}/{${MEME_INDEX}}"
}