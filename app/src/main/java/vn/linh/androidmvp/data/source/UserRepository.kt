package vn.linh.androidmvp.data.source

import io.reactivex.Single
import vn.linh.androidmvp.data.model.AccessToken
import vn.linh.androidmvp.data.source.local.UserLocalDataSource
import vn.linh.androidmvp.data.source.local.api.AccessTokenWrapper
import vn.linh.androidmvp.data.source.remote.UserRemoteDataSource

class UserRepository constructor(private val localDataSource: UserLocalDataSource,
                                 private val remoteDataSource: UserRemoteDataSource,
                                 private val accessTokenWrapper: AccessTokenWrapper
) {

    fun login(username: String, password: String): Single<AccessToken> {
        return remoteDataSource.login(username, password).flatMap {
            accessTokenWrapper.saveAccessToken(it)
            Single.just(it)
        }
    }
}