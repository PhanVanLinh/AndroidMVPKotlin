package vn.linh.androidmvp.screen.base

import android.support.annotation.CallSuper

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BasePresenter protected constructor(private var compositeDisposable: CompositeDisposable) {

    protected fun start() {

    }

    @CallSuper
    protected fun stop() {
        stopSubscriptions()
    }

    protected fun startSubscriber(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    private fun stopSubscriptions() {
        compositeDisposable.clear()
    }
}
