package vn.linh.androidmvp.data.source.remote

import io.reactivex.Single
import vn.linh.androidmvp.data.model.AccessToken
import vn.linh.androidmvp.data.source.remote.api.PotoNoneAuthApi
import vn.linh.androidmvp.data.source.remote.api.request.LoginRequest
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(private val potoNoneAuthApi: PotoNoneAuthApi) {

    fun login(username: String, password: String): Single<AccessToken> {
        return potoNoneAuthApi.login(LoginRequest( username, password))
    }
}