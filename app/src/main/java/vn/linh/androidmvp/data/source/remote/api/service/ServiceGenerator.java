package vn.linh.androidmvp.data.source.remote.api.service;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.Authenticator;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    public static <T> T generate(String baseUrl, Class<T> serviceClass, Gson gson, Authenticator authenticator, Interceptor[] interceptors) {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient().newBuilder();

        for (Interceptor interceptor : interceptors) {
            okHttpClientBuilder.addInterceptor(interceptor);
        }
        okHttpClientBuilder.connectTimeout(10, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(30, TimeUnit.SECONDS);
        if (authenticator != null) {
            okHttpClientBuilder.authenticator(authenticator);
        }
        OkHttpClient okHttpClient = okHttpClientBuilder.build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
        return retrofit.create(serviceClass);
    }
}
