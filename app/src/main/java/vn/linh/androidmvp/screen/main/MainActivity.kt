package vn.linh.androidmvp.screen.main

import android.os.Bundle
import vn.linh.androidmvp.R
import vn.linh.androidmvp.screen.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View{

    @Inject
    lateinit var mainPresenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter.getWeather()
    }
}
