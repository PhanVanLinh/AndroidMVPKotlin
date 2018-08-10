package vn.linh.androidmvp.screen.main

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import vn.linh.androidmvp.data.source.WeatherRepository
import javax.inject.Inject

class MainPresenter @Inject constructor(private val weatherRepository: WeatherRepository) : MainContract.Presenter {


    override fun getWeather(){
        weatherRepository.getForecast(35f,106f)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    Log.i("TAG", "s")
                }, {
                    Log.i("TAG", "ss")
                })
    }

}