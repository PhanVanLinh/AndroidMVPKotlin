package vn.linh.androidmvp.screen.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import vn.linh.androidmvp.R
import vn.linh.androidmvp.screen.base.BaseActivity
import vn.linh.androidmvp.screen.main.MainActivity
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginContract.View {

    @Inject
    lateinit var presenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<Button>(R.id.button_login).setOnClickListener {
            presenter.login()
        }
    }

    override fun onLoginSuccess() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}
