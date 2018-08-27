package vn.linh.androidmvp.data.source.remote.api.middleware

import okhttp3.Interceptor
import okhttp3.Response
import vn.linh.androidmvp.data.source.local.api.AccessTokenWrapper
import javax.inject.Inject

class AuthInterceptor @Inject constructor(private val accessTokenWrapper: AccessTokenWrapper): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val authorisedRequestBuilder = originalRequest.newBuilder()
                .addHeader("Authorization", accessTokenWrapper.getAccessToken()!!.token)
                .header("Accept", "application/json")
        return chain.proceed(authorisedRequestBuilder.build())
    }
}