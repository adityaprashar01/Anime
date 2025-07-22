package com.example.anime.model.api

import com.example.anime.util.Constant
import okhttp3.Interceptor
import okhttp3.Response

class AuthTokenInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalReq = chain.request()
        val reqBuilder = originalReq.newBuilder().header("X-MAL-CLIENT-ID", Constant.CLIENT_ID)
        val request = reqBuilder.build()
        return chain.proceed(request)
    }
}
