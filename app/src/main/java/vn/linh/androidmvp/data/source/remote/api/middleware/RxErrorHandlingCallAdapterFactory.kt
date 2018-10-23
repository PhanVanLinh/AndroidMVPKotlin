package vn.linh.androidmvp.data.source.remote.api.middleware

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import vn.linh.androidmvp.data.source.remote.api.error.RetrofitException
import vn.linh.androidmvp.data.source.remote.api.response.BaseServerErrorResponse
import java.io.IOException
import java.lang.reflect.Type

class RxErrorHandlingCallAdapterFactory(private val gson: Gson) : CallAdapter.Factory() {

    private val original by lazy {
        RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
    }

    companion object {
        private val TAG: String = RxErrorHandlingCallAdapterFactory::class.java.simpleName
        fun create(gson: Gson): CallAdapter.Factory = RxErrorHandlingCallAdapterFactory(gson)
    }

    override fun get(returnType: Type, annotations: Array<Annotation>,
        retrofit: Retrofit): CallAdapter<*, *> {
        val wrapped = original.get(returnType, annotations, retrofit) as CallAdapter<*, *>
        return RxCallAdapterWrapper(wrapped)
    }

    private inner class RxCallAdapterWrapper<R>(
        val wrappedCallAdapter: CallAdapter<R, *>
    ) : CallAdapter<R, Single<R>> {

        override fun responseType(): Type = wrappedCallAdapter.responseType()


        @Suppress("UNCHECKED_CAST")
        override fun adapt(call: Call<R>): Single<R>? {
            return (wrappedCallAdapter.adapt(
                call) as Single<R>).onErrorResumeNext { throwable: Throwable ->
                Single.error(asRetrofitException(throwable))
            }
        }

        private fun asRetrofitException(throwable: Throwable): RetrofitException {
            if (throwable is HttpException) {
                val response = throwable.response()
                if (response.errorBody() != null) {
                    try {
                        val errorResponse = response.errorBody()!!.string()
                        val serverErrorResponse = deserializeServerError(errorResponse)
                        return if (serverErrorResponse != null && !serverErrorResponse.success) {
                            RetrofitException.serverError(serverErrorResponse)
                        } else RetrofitException.httpError(response)
                    } catch (e: IOException) {
                        Log.e(TAG, e.message)
                    }
                }

            }

            if (throwable is IOException) {
                return RetrofitException.networkError(throwable)
            }
            return RetrofitException.unexpectedError(throwable)
        }

        private fun deserializeServerError(errorString: String): BaseServerErrorResponse? {
            return try {
                gson.fromJson(errorString, BaseServerErrorResponse::class.java)
            } catch (e: JsonSyntaxException) {
                null
            }
        }
    }
}