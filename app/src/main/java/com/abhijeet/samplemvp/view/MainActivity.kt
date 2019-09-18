package com.abhijeet.samplemvp.view

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.abhijeet.samplemvp.R
import com.abhijeet.samplemvp.base.BaseActivity
import com.abhijeet.samplemvp.data_model.Hero
import com.abhijeet.samplemvp.mvp.activity_main.IMainContractor
import com.abhijeet.samplemvp.mvp.activity_main.MainPresenter

class MainActivity : BaseActivity<MainPresenter>(), IMainContractor.View {

    override fun onCreatePresenter(): MainPresenter {
        return MainPresenter(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //presenter = MainPresenter(this)

        presenter?.getData()

    }

    override fun showError(errorMsg: String) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show();
    }

    override fun showData(listHero: List<Hero>) {
        var s: String = "";
        for (hero in listHero) {
            s = "\n" + s.plus(hero.name)
        }

        findViewById<TextView>(R.id.tvHello).text = s;
    }

    override fun initView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addFieldChangedListener() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgessbar() {
        showProgressBar()
    }

    override fun hideProgressbar() {
        hideProgressBar()
    }
}
