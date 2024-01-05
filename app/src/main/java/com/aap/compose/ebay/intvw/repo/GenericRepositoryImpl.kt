package com.aap.compose.ebay.intvw.repo

import com.aap.compose.ebay.intvw.data.EqDataVO
import com.aap.compose.ebay.intvw.network.EqService
import org.jetbrains.annotations.VisibleForTesting
import javax.inject.Inject

private const val STALENESS_THRESHOLD = 5 * 60 * 1000L // 5 min refresh
class GenericRepositoryImpl @Inject constructor(private val eqService: EqService) : GenericRepository {
    @VisibleForTesting
    var timestamp = 0L
    var localCache: List<EqDataVO>? = null

    override suspend fun fetchEarthquakeList(): GenericResponse {
            try {
                val response = eqService.getEarthquakeList()
                if (response.earthquakes.isNotEmpty()) {
                    localCache = response.earthquakes
                    return GenericResponse.GenericSuccess(response.earthquakes)
                } else {
                    return GenericResponse.GenericError(null, "Failure")
                }
            } catch (exception: Exception) {
                return GenericResponse.GenericError(exception, exception.toString())
            }

    }

    override fun getEarthquake(index: Int): EqDataVO? {
        return localCache?.getOrNull(index)
    }
}