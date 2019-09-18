package com.abhijeet.samplemvp.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import rx.Subscription

open class BasePresenter<V : IBaseView, M : BaseModel> {
    protected var view: V? = null
    protected var model: M? = null

    private var compositeDisposable = CompositeDisposable()

    fun addSubscribe(disposable: Disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = CompositeDisposable()
        }

        compositeDisposable.add(disposable)
    }

    fun unSubscribe() {
        if (compositeDisposable != null && compositeDisposable.isDisposed) {
            compositeDisposable.clear()
        }

    }

}