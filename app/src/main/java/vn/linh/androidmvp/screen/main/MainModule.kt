package vn.linh.androidmvp.screen.main

import dagger.Binds
import dagger.Module
import vn.linh.androidmvp.di.scope.ActivityScope

@Module
abstract class MainModule {

    @Binds
    @ActivityScope
    abstract fun bindMainPresenter(mainPresenter: MainPresenter): MainContract.Presenter
}