package com.abhijeet.samplemvp.api


import com.abhijeet.samplemvp.App
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

import java.io.File
import java.util.concurrent.TimeUnit

import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Retrofit implementation
 */
class ApiEngine private constructor() {
    private val retrofit: Retrofit

    val apiService: ApiService
        get() = retrofit.create(ApiService::class.java)

    init {
        //Log interceptor
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        //Cache
        val size = 1024 * 1024 * 100
        val cacheFile = File(App().getContext().cacheDir, "OkHttpCache")
        val cache = Cache(cacheFile, size.toLong())

        val client = OkHttpClient.Builder()
            .connectTimeout(25, TimeUnit.SECONDS)
            .writeTimeout(25, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addNetworkInterceptor(NetworkInterceptor())
            .addInterceptor(loggingInterceptor)
            .cache(cache)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(ApiService.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    }

    companion object {

        @Volatile
        private var apiEngine: ApiEngine? = null

        val instance: ApiEngine?
            get() {
                if (apiEngine == null) {
                    synchronized(ApiEngine::class.java) {
                        if (apiEngine == null) {
                            apiEngine = ApiEngine()
                        }
                    }
                }
                return apiEngine
            }
    }


}