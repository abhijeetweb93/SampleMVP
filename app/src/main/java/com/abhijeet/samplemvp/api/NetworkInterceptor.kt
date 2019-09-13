package com.abhijeet.samplemvp.api


import com.abhijeet.samplemvp.App
import com.abhijeet.samplemvp.app_util.NetUtil
import com.abhijeet.samplemvp.logger.Logger

import java.io.IOException

import okhttp3.CacheControl
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import rx.schedulers.Schedulers

class NetworkInterceptor : Interceptor {
    val TAG = NetworkInterceptor::class.java.simpleName

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {

        var request = chain.request()

        //No cache is used when there is no network
        if (!NetUtil().isConnected(App().getContext())) {
            request = request.newBuilder()
                .cacheControl(CacheControl.FORCE_CACHE)
                .build()
        }

        val response = chain.proceed(request)

        //        new Logger().log
        //
        //        Logger.log(TAG, "\n Request Message: "+response.request().toString()+"\n Responce: "+response.body());

        if (NetUtil().isConnected(App().getContext())) {
            // When there is a network, set the timeout to 0
            val maxStale = 0
            response.newBuilder()
                .header("Cache-Control", "public, max-tvAgeField=$maxStale")
                .removeHeader("Pragma")// Clear the header information, because if the server does not support, will return some interference information, do not clear the following can not take effect
                .build()
        } else {
            // When there is no network, set the timeout to 3 weeks
            val maxStale = 60 * 60 * 24 * 21
            response.newBuilder()
                .header("Cache-Control", "public, only-if-cached, max-stale=$maxStale")
                .removeHeader("Pragma")
                .build()
        }

        return response
    }

}
