package vn.linh.androidmvp.data.source.remote.api

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import vn.linh.androidmvp.data.model.AccessToken
import vn.linh.androidmvp.data.source.remote.api.request.LoginRequest

interface PotoNoneAuthApi {

    @POST("/login")
    fun login(@Body request: LoginRequest): Single<AccessToken>

    @POST("refresh_token")
    @FormUrlEncoded
    fun refreshToken(@Field("refresh_token") refreshToken: String): Single<AccessToken>

}