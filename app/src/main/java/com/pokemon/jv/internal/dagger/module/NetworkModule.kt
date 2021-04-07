package com.pokemon.jv.internal.dagger.module

import android.content.Context
import com.pokemon.data.network.Endpoints
import com.pokemon.data.network.RestApi
import com.pokemon.data.network.RestApiImpl
import com.pokemon.data.network.RestService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpBuilder(context: Context): OkHttpClient.Builder {
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()
        return okHttpClient.newBuilder()
    }

    @Provides
    @Singleton
    fun provideRestService(httpClientBuilder: OkHttpClient.Builder): RestService {
        val retrofit = Retrofit.Builder()
            .baseUrl(Endpoints.URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClientBuilder.build())
            .build()
        return retrofit.create(RestService::class.java)
    }

    @Provides
    @Singleton
    fun provideRestApi(
        context: Context,
        restService: RestService
    ): RestApi {
        return RestApiImpl(context, restService)
    }
}