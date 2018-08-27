package vn.linh.androidmvp.data.source.remote.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import vn.linh.androidmvp.data.model.Image

class GetImageResponse {

    @SerializedName("images")
    @Expose
    var images: List<Image>? = null
}
