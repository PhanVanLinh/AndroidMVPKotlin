package vn.linh.androidmvp.data.source.remote.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import vn.linh.androidmvp.data.model.Forecast

data class ForecastResponse(

        @Expose
        val cod: String,

        @Expose
        val message: Float,

        @Expose
        @SerializedName("list")
        val weatherData: List<Forecast>
)