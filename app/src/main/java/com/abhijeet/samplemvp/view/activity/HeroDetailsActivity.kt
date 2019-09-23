package com.abhijeet.samplemvp.view.activity

import android.os.Bundle
import com.abhijeet.samplemvp.R
import com.abhijeet.samplemvp.base.BaseActivity
import com.abhijeet.samplemvp.base.BaseModel
import com.abhijeet.samplemvp.base.BasePresenter
import com.abhijeet.samplemvp.base.IBaseView
import com.abhijeet.samplemvp.data_model.Hero
import com.abhijeet.samplemvp.databinding.ActivityHeroDetailsBinding
import com.bumptech.glide.Glide


class HeroDetailsActivity : BaseActivity<BasePresenter<IBaseView, BaseModel>>() {
    override fun initPresenter(): BasePresenter<IBaseView, BaseModel> {
        return BasePresenter()
    }

    var binding: ActivityHeroDetailsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = putContentView(R.layout.activity_hero_details)

        if (getIntent().hasExtra("hero")) {
            val hero = getIntent().extras?.get("hero") as Hero
            binding?.hero = hero

            binding?.ivProfile?.let {
                Glide
                    .with(this)
                    .load(hero.imageurl)
                    .centerCrop()
                    .placeholder(android.R.drawable.ic_btn_speak_now)
                    .into(it)
            }
        }
    }
}
