package vn.linh.androidmvp.data.source.remote.api.request

import com.google.gson.annotations.Expose

data class LoginRequest(
        @Expose
        var userName: String,
        @Expose
        var password: String)
