package com.example.chucknorris.network

import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()
        val url = req.url.newBuilder()
        req = req.newBuilder().url(url.build()).build()
        return chain.proceed(req)
    }
}