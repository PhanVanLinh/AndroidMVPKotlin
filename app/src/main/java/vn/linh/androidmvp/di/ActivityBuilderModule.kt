package vn.linh.androidmvp.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import vn.linh.androidmvp.di.scope.ActivityScope
import vn.linh.androidmvp.screen.login.LoginActivity
import vn.linh.androidmvp.screen.login.LoginModule
import vn.linh.androidmvp.screen.main.MainActivity
import vn.linh.androidmvp.screen.main.MainModule

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [MainModule::class])
    @ActivityScope
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [LoginModule::class])
    @ActivityScope
    abstract fun bindLoginActivity(): LoginActivity
}