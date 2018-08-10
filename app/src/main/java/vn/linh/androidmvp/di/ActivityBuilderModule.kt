package vn.linh.androidmvp.di

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import vn.linh.androidmvp.di.scope.ActivityScope
import vn.linh.androidmvp.screen.main.MainActivity
import vn.linh.androidmvp.screen.main.MainModule

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [MainModule::class])
    @ActivityScope
    abstract fun bindMainActivity(): MainActivity
}