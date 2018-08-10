package vn.linh.androidmvp.data.model

import com.google.gson.annotations.SerializedName

data class Forecast(

        @SerializedName("wind")
        val wind: Wind,

        @SerializedName("weather")
        val weather:Weather
)