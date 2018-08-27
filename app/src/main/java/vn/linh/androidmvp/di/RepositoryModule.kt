package vn.linh.androidmvp.di

import dagger.Module
import dagger.Provides
import vn.linh.androidmvp.data.source.UserRepository
import vn.linh.androidmvp.data.source.local.UserLocalDataSource
import vn.linh.androidmvp.data.source.local.api.AccessTokenWrapper
import vn.linh.androidmvp.data.source.remote.UserRemoteDataSource
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideWeatherRepository(localDataSource: UserLocalDataSource, remoteDataSource: UserRemoteDataSource, accessTokenWrapper: AccessTokenWrapper): UserRepository {
        return UserRepository(localDataSource, remoteDataSource, accessTokenWrapper)
    }
}