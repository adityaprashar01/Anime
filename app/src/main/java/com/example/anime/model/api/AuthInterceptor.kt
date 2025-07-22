package com.example.anime.model.api

import okhttp3.Interceptor
import okhttp3.Response

class AuthTokenInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalReq = chain.request()
        val reqBuilder = originalReq.newBuilder().header("X-MAL-CLIENT-ID","a8e97fa29f95ada3168ae089d8be965b")
        val request = reqBuilder.build()
        return chain.proceed(request)
    }
}
