package vn.linh.androidmvp.data.source.remote.api.middleware

import android.util.Log
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import vn.linh.androidmvp.data.source.local.api.AccessTokenWrapper
import vn.linh.androidmvp.data.source.remote.api.PotoNoneAuthApi
import javax.inject.Inject

class TokenAuthenticator @Inject constructor(private val noneAuthAPI: PotoNoneAuthApi, private val accessTokenWrapper: AccessTokenWrapper) : Authenticator {

    override fun authenticate(route: Route, response: Response): Request? {
        val newAccessToken = noneAuthAPI.refreshToken(accessTokenWrapper.getAccessToken()!!.refreshToken).blockingGet()
        accessTokenWrapper.saveAccessToken(newAccessToken)
        Log.i("TAG", "authenticator")
        return response.request().newBuilder()
                .header("Authorization", newAccessToken.token)
                .build()
    }
}