package com.aap.compose.ebay.intvw.hilt

import com.aap.compose.ebay.intvw.network.EqService
import com.aap.compose.ebay.intvw.network.GenericService
import com.aap.compose.ebay.intvw.repo.GenericRepository
import com.aap.compose.ebay.intvw.repo.GenericRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

private const val SERVER_ADDRESS = "ServerAddress"
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, @Named(SERVER_ADDRESS) url: String): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(url)

            .client(okHttpClient)
            .build()

    @Provides
    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    fun provideEarthquakeService(retrofit: Retrofit): EqService =
        retrofit.create(EqService::class.java)


    @Provides
    fun provideGenericService(retrofit: Retrofit): GenericService =
        retrofit.create(GenericService::class.java)


    @Singleton
    @Provides
    fun provideGenericRepository(eqService: EqService): GenericRepository {
        return GenericRepositoryImpl(eqService)
    }

    @Provides
    @Named(SERVER_ADDRESS)
    fun provideServerAddress(): String = "http://api.geonames.org"

}