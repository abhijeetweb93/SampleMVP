package com.abhijeet.samplemvp.mvp.activity_main

import com.abhijeet.samplemvp.data_model.Hero
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class MainPresenter (): IMainContractor.Presenter() {

    constructor(view: IMainContractor.View) : this() {
        this.view = view
        this.model = MainModel()
    }


    override fun getData() {
        view?.showProgessbar()


        val subscription = model?.getData()?.subscribe(object : Observer<List<Hero>> {
            override fun onComplete() {
                view?.hideProgressbar()
            }

            override fun onSubscribe(d: Disposable) {
                addSubscribe(d)
            }

            override fun onNext(t: List<Hero>) {
                view?.showData(t)
            }

            override fun onError(e: Throwable) {
                view?.showError(e.message + "")
            }
        })




    }
}