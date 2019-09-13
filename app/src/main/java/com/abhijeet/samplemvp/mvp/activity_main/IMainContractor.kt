package com.abhijeet.samplemvp.mvp.activity_main

import com.abhijeet.samplemvp.base.IBaseView
import com.abhijeet.samplemvp.data_model.Hero
import io.reactivex.Observable

interface IMainContractor {
    interface View : IBaseView {
        fun showData(listHero: List<Hero>)
        fun showError(errorMsg:String)
    }

    interface Presenter {
        fun getData()
    }

    interface Model {
        fun getData(): Observable<List<Hero>>
    }
}