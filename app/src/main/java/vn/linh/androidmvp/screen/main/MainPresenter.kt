package vn.linh.androidmvp.screen.main

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import vn.linh.androidmvp.data.source.remote.api.ImageRepository
import javax.inject.Inject

class MainPresenter @Inject constructor(private val imageRepository: ImageRepository) : MainContract.Presenter {

    override fun getImage() {
        imageRepository.getImage()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    Log.i("TAG", "s")
                }, {
                    it.printStackTrace()
                })
    }

}