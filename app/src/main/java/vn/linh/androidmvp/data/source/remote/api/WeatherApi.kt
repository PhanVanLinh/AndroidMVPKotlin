package vn.linh.androidmvp.data.source.remote.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import vn.linh.androidmvp.data.source.remote.api.response.ForecastResponse

interface WeatherApi {

    @GET("/data/2.5/forecast")
    fun getForecast(@Query("lat") lat: Float, @Query("lon") lon: Float): Single<ForecastResponse>

}