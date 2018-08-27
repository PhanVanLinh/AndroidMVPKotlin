package vn.linh.androidmvp.data.source.local.api

import vn.linh.androidmvp.data.model.AccessToken

class AccessTokenWrapper constructor(private val sharedPrefApi: SharedPrefApi) {
    private var accessToken: AccessToken? = null

    fun getAccessToken(): AccessToken? {
        if (accessToken == null) {
            accessToken = sharedPrefApi.getObject(SharedPrefApi.ACCESS_TOKEN, AccessToken::class.java)
        }
        return accessToken
    }

    fun saveAccessToken(accessToken: AccessToken) {
        this.accessToken = accessToken
        sharedPrefApi.putObject(SharedPrefApi.ACCESS_TOKEN, accessToken)
    }
}