package vn.linh.androidmvp.data.model

import com.google.gson.annotations.Expose

data class AccessToken(
        @Expose
        var token: String,

        @Expose
        var refreshToken: String)