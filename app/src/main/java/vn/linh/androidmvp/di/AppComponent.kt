package vn.linh.androidmvp.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import vn.linh.androidmvp.WeatherApp
import android.app.Application
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ActivityBuilderModule::class, RepositoryModule::class, NetworkModule::class])
interface AppComponent : AndroidInjector<WeatherApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}