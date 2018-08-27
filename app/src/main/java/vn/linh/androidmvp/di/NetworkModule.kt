package vn.linh.androidmvp.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.logging.HttpLoggingInterceptor
import vn.linh.androidmvp.BuildConfig
import vn.linh.androidmvp.data.source.remote.api.PotoAuthApi
import vn.linh.androidmvp.data.source.remote.api.PotoNoneAuthApi
import vn.linh.androidmvp.data.source.remote.api.middleware.AuthInterceptor
import vn.linh.androidmvp.data.source.remote.api.middleware.NoneAuthInterceptor
import vn.linh.androidmvp.data.source.remote.api.middleware.TokenAuthenticator
import vn.linh.androidmvp.data.source.remote.api.service.ServiceGenerator
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @Singleton
    @Provides
    fun providePotoAuthApi(gson: Gson, authInterceptor: AuthInterceptor, loggingInterceptor: HttpLoggingInterceptor, tokenAuthenticator: TokenAuthenticator): PotoAuthApi {
        val interceptors = arrayOf(authInterceptor, loggingInterceptor)
        return ServiceGenerator.generate(BuildConfig.BASE_URL, PotoAuthApi::class.java, gson, tokenAuthenticator, interceptors)
    }

    @Singleton
    @Provides
    fun providePotoNoneAuthApi(gson: Gson, noneAuthInterceptor: NoneAuthInterceptor, loggingInterceptor: HttpLoggingInterceptor): PotoNoneAuthApi {
        val interceptors = arrayOf(noneAuthInterceptor, loggingInterceptor)
        return ServiceGenerator.generate(BuildConfig.BASE_URL, PotoNoneAuthApi::class.java, gson, null, interceptors)
    }
}