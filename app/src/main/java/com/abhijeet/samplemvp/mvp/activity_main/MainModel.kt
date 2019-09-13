package com.abhijeet.samplemvp.mvp.activity_main

import com.abhijeet.samplemvp.api.ApiEngine
import com.abhijeet.samplemvp.data_model.Hero
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MainModel : IMainContractor.Model {
    override fun getData(): Observable<List<Hero>> {
        return ApiEngine.instance!!.apiService.getHeroes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}