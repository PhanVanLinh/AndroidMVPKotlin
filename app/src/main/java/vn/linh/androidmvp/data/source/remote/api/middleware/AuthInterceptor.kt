package vn.linh.androidmvp.data.source.remote.api.middleware

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response
import vn.linh.androidmvp.BuildConfig

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()
        val url: HttpUrl = originalHttpUrl.newBuilder().addQueryParameter("appid", BuildConfig.APP_ID).build()
        val requestBuilder = original.newBuilder().url(url)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}