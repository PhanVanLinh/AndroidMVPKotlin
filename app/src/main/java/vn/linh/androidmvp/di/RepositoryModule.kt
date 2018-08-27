package vn.linh.androidmvp.di

import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import vn.linh.androidmvp.data.source.UserRepository
import vn.linh.androidmvp.data.source.local.UserLocalDataSource
import vn.linh.androidmvp.data.source.local.api.AccessTokenWrapper
import vn.linh.androidmvp.data.source.local.api.SharedPrefApi
import vn.linh.androidmvp.data.source.remote.UserRemoteDataSource
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideSharedPrefApi(context: Context, gson: Gson): SharedPrefApi {
        return SharedPrefApi(context, gson)
    }

    @Singleton
    @Provides
    fun provideAccessTokenWrapper(sharedPrefApi: SharedPrefApi) : AccessTokenWrapper{
        return AccessTokenWrapper(sharedPrefApi)
    }

    @Singleton
    @Provides
    fun provideUserRepository(localDataSource: UserLocalDataSource, remoteDataSource: UserRemoteDataSource, accessTokenWrapper: AccessTokenWrapper): UserRepository {
        return UserRepository(localDataSource, remoteDataSource, accessTokenWrapper)
    }
}