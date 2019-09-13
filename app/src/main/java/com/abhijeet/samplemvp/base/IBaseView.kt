package com.abhijeet.samplemvp.base

interface IBaseView {
    fun initView()
    fun addFieldChangedListener()
    fun showProgessbar()
    fun hideProgressbar()
}