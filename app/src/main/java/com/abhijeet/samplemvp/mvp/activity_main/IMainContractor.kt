package com.abhijeet.samplemvp.mvp.activity_main

import com.abhijeet.samplemvp.base.BaseModel
import com.abhijeet.samplemvp.base.BasePresenter
import com.abhijeet.samplemvp.base.IBaseView
import com.abhijeet.samplemvp.data_model.Hero
import io.reactivex.Observable

interface IMainContractor {

    interface View : IBaseView {
        fun showData(listHero: List<Hero>)
        fun showError(errorMsg: String)
    }

    abstract class Presenter : BasePresenter<View,Model>() {
        abstract fun getData()
    }

    interface Model : BaseModel {
        fun getData(): Observable<List<Hero>>
    }
}