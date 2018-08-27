package vn.linh.androidmvp.screen.login

import dagger.Binds
import dagger.Module
import vn.linh.androidmvp.di.scope.ActivityScope

@Module
abstract class LoginModule{

    @Binds
    @ActivityScope
    abstract fun bindLoginView(loginActivity: LoginActivity): LoginContract.View

    @Binds
    @ActivityScope
    abstract fun bindLoginPresenter(loginPresenter: LoginPresenter): LoginContract.Presenter
}