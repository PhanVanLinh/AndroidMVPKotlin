package vn.linh.androidmvp.data.source

import io.reactivex.Single
import vn.linh.androidmvp.data.model.Forecast
import vn.linh.androidmvp.data.source.local.WeatherLocalDataSource
import vn.linh.androidmvp.data.source.remote.WeatherRemoteDataSource
import javax.inject.Inject

class WeatherRepository constructor(private val weatherLocalDataSource: WeatherLocalDataSource,
                                    private val weatherRemoteDataSource: WeatherRemoteDataSource) {

    fun getForecast(lat: Float, lon: Float): Single<List<Forecast>> {
        return weatherRemoteDataSource.getForecast(lat, lon).map {
            it.weatherData
        }
    }
}