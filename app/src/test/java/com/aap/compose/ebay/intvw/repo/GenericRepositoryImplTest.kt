package com.aap.compose.ebay.intvw.repo

import com.aap.compose.ebay.intvw.data.MemeContainerVO
import com.aap.compose.ebay.intvw.data.MemeDataResponseVO
import com.aap.compose.ebay.intvw.data.GenericDataVO
import com.aap.compose.ebay.intvw.network.GenericService
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GenericRepositoryImplTest {
    private lateinit var genericService: GenericService
    private lateinit var memeRepository:  GenericRepositoryImpl

    @Before
    fun setup() {
        genericService = mockk<GenericService>()
        memeRepository = GenericRepositoryImpl(genericService)
    }

    @Test
    fun `verify getTopMemes Api happy path`() = runTest {
        val meme = GenericDataVO("1", "abc", "url", 10, 10, 1, 1)
        val memeDataResponseVO = MemeDataResponseVO(true, MemeContainerVO(listOf(meme)))
        coEvery { genericService.getTopMemes() } returns memeDataResponseVO

        val actual = memeRepository.fetchDataList() as? GenericResponse.GenericSuccess

        Assert.assertNotNull(actual)
        Assert.assertEquals(memeDataResponseVO.data.memes, (actual as GenericResponse.GenericSuccess).memes)
    }

    @Test
    fun `verify when getTopMemes throws error it is caught`() = runTest {
        val message = "Something is wrong"
        coEvery { genericService.getTopMemes() } throws Exception(message)

        val actual = memeRepository.fetchDataList() as? GenericResponse.GenericError

        Assert.assertNotNull(actual)
        Assert.assertTrue(actual?.throwable is Exception)
        Assert.assertEquals(message, actual?.throwable?.message)
    }

    @Test
    fun `verify when cached response present it is returned`() {

    }

    @Test
    fun `verify when cached response is stale  it is not returned`() {

    }
}