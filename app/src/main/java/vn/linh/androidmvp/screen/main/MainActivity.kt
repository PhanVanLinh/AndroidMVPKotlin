package vn.linh.androidmvp.screen.main

import android.os.Bundle
import android.view.View
import vn.linh.androidmvp.R
import vn.linh.androidmvp.screen.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View{

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.layout_load_image).setOnClickListener {
            presenter.getImage()
        }
    }
}
