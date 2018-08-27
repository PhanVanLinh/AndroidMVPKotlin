package vn.linh.androidmvp.screen.login

/**
 * Created by PhanVanLinh on 11/04/2018.
 * phanvanlinh.94vn@gmail.com
 */

interface LoginContract {

    interface Presenter {

        fun login()
    }

    interface View {

        fun onLoginSuccess()
    }
}
