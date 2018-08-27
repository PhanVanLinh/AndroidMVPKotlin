package vn.linh.androidmvp.data.source.remote.api

import io.reactivex.Single
import retrofit2.http.GET
import vn.linh.androidmvp.data.source.remote.api.response.GetImageResponse

interface PotoAuthApi {

    @GET("api/images")
    fun getImage(): Single<GetImageResponse>

}