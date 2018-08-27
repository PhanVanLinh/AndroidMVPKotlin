package vn.linh.androidmvp.data.model

import com.google.gson.annotations.Expose

data class Image(
        @Expose
        val title: String,
        @Expose
        val description: String,
        @Expose
        val thumb: String,
        @Expose
        val image: String
)
