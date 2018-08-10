package vn.linh.androidmvp.data.source.remote

import io.reactivex.Single
import vn.linh.androidmvp.data.source.remote.api.WeatherApi
import vn.linh.androidmvp.data.source.remote.api.response.ForecastResponse
import javax.inject.Inject

class WeatherRemoteDataSource @Inject constructor(private val weatherApi: WeatherApi) {

    fun getForecast(lat: Float, lon: Float): Single<ForecastResponse> {
        return weatherApi.getForecast(lat, lon)
    }
}