package com.abhijeet.samplemvp.mvp.activity_main

import com.abhijeet.samplemvp.data_model.Hero
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class MainPresenter(val view: IMainContractor.View) : IMainContractor.Presenter {
    val model: MainModel = MainModel()
    override fun getData() {
        view.showProgessbar()


        model.getData().subscribe(object : Observer<List<Hero>> {
            override fun onComplete() {
                view.hideProgressbar()
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: List<Hero>) {
                view.showData(t)
            }

            override fun onError(e: Throwable) {
                view.showError(e.message + "")
            }
        })


//        val subscription = model.getData().subscribe(object : Subscriber<List<Hero>>() {
//            override fun onCompleted() {
//                view.hideProgressbar()
//            }
//
//            override fun onError(e: Throwable) {
//                //Log.e("121",param_value+" "+param_name+" "+parent_id);
//                view.showError(e.message + "")
//            }
//
//            override fun onNext(csfChecklist1: List<Hero>) {
//                //Logger.log(TAG, csfChecklist1.getParam_name());
//                view.showData(csfChecklist1)
//            }
//        })


    }
}