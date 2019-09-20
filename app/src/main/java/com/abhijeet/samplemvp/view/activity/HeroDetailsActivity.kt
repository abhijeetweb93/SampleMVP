package com.abhijeet.samplemvp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.abhijeet.samplemvp.R
import com.abhijeet.samplemvp.base.BaseActivity
import com.abhijeet.samplemvp.base.BaseModel
import com.abhijeet.samplemvp.base.BasePresenter
import com.abhijeet.samplemvp.base.IBaseView
import com.abhijeet.samplemvp.data_model.Hero
import com.abhijeet.samplemvp.databinding.ActivityHeroDetailsBinding


class HeroDetailsActivity :AppCompatActivity() {



    var binding:ActivityHeroDetailsBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_hero_details)
//        setContentView(R.layout.activity_hero_details)

        if (getIntent().hasExtra("hero")) {
            val hero = getIntent().extras?.get("hero") as Hero
        }
    }
}
