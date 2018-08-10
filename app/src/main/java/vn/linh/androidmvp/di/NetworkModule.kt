package vn.linh.androidmvp.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vn.linh.androidmvp.BuildConfig
import vn.linh.androidmvp.data.source.remote.api.WeatherApi
import vn.linh.androidmvp.data.source.remote.api.middleware.AuthInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    private val CONNECT_TIMEOUT = 10

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Singleton
    @Provides
    @Named("auth")
    fun provideAuthInterceptor(): Interceptor {
        return AuthInterceptor()
    }

    @Singleton
    @Provides
    fun provideHttpClient(@Named("auth") interceptor: Interceptor): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.connectTimeout(CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            clientBuilder.addInterceptor(logging)
        }
        clientBuilder.addInterceptor(interceptor)
        return clientBuilder.build()
    }

    @Singleton
    @Provides
    fun provideWeatherApi(client: OkHttpClient, gson: Gson): WeatherApi {
        return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(WeatherApi::class.java)
    }
}