package vn.linh.androidmvp.screen.login

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import vn.linh.androidmvp.data.source.UserRepository
import javax.inject.Inject

/**
 * Created by PhanVanLinh on 11/04/2018.
 * phanvanlinh.94vn@gmail.com
 */

class LoginPresenter @Inject constructor(private val view: LoginContract.View, private val userRepository: UserRepository) : LoginContract.Presenter {

    override fun login() {
        userRepository.login("keanu", "keanu")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                     view.onLoginSuccess()
                }, {})
    }
}
