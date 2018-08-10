package vn.linh.androidmvp.di

import dagger.Module
import dagger.Provides
import vn.linh.androidmvp.data.source.WeatherRepository
import vn.linh.androidmvp.data.source.local.WeatherLocalDataSource
import vn.linh.androidmvp.data.source.remote.WeatherRemoteDataSource
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideWeatherRepository(localDataSource: WeatherLocalDataSource, remoteDataSource: WeatherRemoteDataSource): WeatherRepository {
        return WeatherRepository(localDataSource, remoteDataSource)
    }
}