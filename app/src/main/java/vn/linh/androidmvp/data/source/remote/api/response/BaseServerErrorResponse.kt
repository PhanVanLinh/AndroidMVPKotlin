package vn.linh.androidmvp.data.source.remote.api.response

import com.google.gson.annotations.Expose

data class BaseServerErrorResponse(
    @Expose
    val success: Boolean,
    @Expose
    val error: Error
) {
    data class Error(
        @Expose
        val code: Int,
        @Expose
        val message: String
    )
}