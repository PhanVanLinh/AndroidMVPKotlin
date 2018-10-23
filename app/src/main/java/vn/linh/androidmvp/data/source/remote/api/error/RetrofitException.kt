package vn.linh.androidmvp.data.source.remote.api.error

import retrofit2.Response
import vn.linh.androidmvp.data.source.remote.api.response.BaseServerErrorResponse
import java.io.IOException

class RetrofitException(
    private val kind: Kind,
    private val serverErrorResponse: BaseServerErrorResponse? = null,
    private val response: Response<*>? = null,
    private val exception: Throwable? = null
) : RuntimeException() {

    companion object {
        fun httpError(response: Response<*>): RetrofitException {
            return RetrofitException(Kind.HTTP, null, response)
        }

        fun serverError(serverErrorResponse: BaseServerErrorResponse): RetrofitException {
            return RetrofitException(Kind.SERVER, serverErrorResponse)
        }

        fun networkError(throwable: Throwable): RetrofitException {
            return RetrofitException(Kind.NETWORK, null, null, throwable)
        }

        fun unexpectedError(throwable: Throwable): RetrofitException {
            return RetrofitException(Kind.UNEXPECTED, null, null, throwable)
        }
    }

    fun getServerErrors(): BaseServerErrorResponse.Error? {
        return if (kind == Kind.SERVER && serverErrorResponse != null) {
            serverErrorResponse.error
        } else null
    }

    enum class Kind {
        /** An [IOException] occurred while communicating to the server.  */
        NETWORK,
        /** A non-200 HTTP status code was received from the server.  */
        HTTP,
        /**
         * A child of [HTTP]. If we able to cast error to [BaseServerErrorResponse] => error is [SERVER] error
         */
        SERVER,
        /**
         * An internal error occurred while attempting to execute a request. It is best practice to
         * re-throw this exception so your application crashes.
         */
        UNEXPECTED
    }
}