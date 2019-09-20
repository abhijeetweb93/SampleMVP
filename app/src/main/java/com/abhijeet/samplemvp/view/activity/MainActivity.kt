package com.abhijeet.samplemvp.view.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.abhijeet.samplemvp.R
import com.abhijeet.samplemvp.base.BaseActivity
import com.abhijeet.samplemvp.data_model.Hero
import com.abhijeet.samplemvp.databinding.ActivityMainBinding
import com.abhijeet.samplemvp.logger.AppAlert
import com.abhijeet.samplemvp.logger.Logger
import com.abhijeet.samplemvp.mvp.activity_main.IMainContractor
import com.abhijeet.samplemvp.mvp.activity_main.MainPresenter
import com.abhijeet.samplemvp.view.adapter.MainActivityRVAdapter

class MainActivity : BaseActivity<MainPresenter>(), IMainContractor.View {
    private val TAG = MainActivity::class.java.simpleName

    var binding: ActivityMainBinding? = null

    override fun initPresenter(): MainPresenter {
        return MainPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        Logger().log(TAG, "onCreate Method")
        binding = putContentView(R.layout.activity_main)


        presenter?.getData()

    }

    override fun showError(errorMsg: String) {
        AppAlert().showAlert(binding?.rView!!,errorMsg)
    }

    override fun showData(listHero: List<Hero>) {
        binding?.rView.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            this!!.layoutManager = LinearLayoutManager(this@MainActivity)
            // set the custom adapter to the RecyclerView
            adapter = MainActivityRVAdapter(listHero)
        }
    }

    override fun initView() {
    }

    override fun addFieldChangedListener() {
    }

    override fun showProgessbar() {
        baseBinding?.progressBar?.visibility = View.VISIBLE
    }

    override fun hideProgressbar() {
        baseBinding?.progressBar?.visibility = View.INVISIBLE
    }
}
