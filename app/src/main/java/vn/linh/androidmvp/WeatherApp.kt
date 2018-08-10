package vn.linh.androidmvp

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import vn.linh.androidmvp.di.DaggerAppComponent

class WeatherApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}