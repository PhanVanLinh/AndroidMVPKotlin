package vn.linh.androidmvp.data.source.remote

import io.reactivex.Single
import vn.linh.androidmvp.data.source.remote.api.PotoAuthApi
import vn.linh.androidmvp.data.source.remote.api.response.GetImageResponse
import javax.inject.Inject

/**
 * Created by PhanVanLinh on 11/04/2018.
 * phanvanlinh.94vn@gmail.com
 */

class ImageRemoteDataSource @Inject constructor(private val potoAuthApi: PotoAuthApi) {

    fun getImage(): Single<GetImageResponse> {
        return potoAuthApi.getImage()
    }
}