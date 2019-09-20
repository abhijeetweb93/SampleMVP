package com.abhijeet.samplemvp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.abhijeet.samplemvp.R
import com.abhijeet.samplemvp.data_model.Hero
import com.abhijeet.samplemvp.databinding.ListItemLayoutBinding
import com.abhijeet.samplemvp.logger.AppAlert
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item_layout.view.*

class MainActivityRVAdapter(val heroList: List<Hero>) : RecyclerView.Adapter<MainActivityRVAdapter.MyViewHolder>() {

    var db:ListItemLayoutBinding?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        db =DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.list_item_layout, parent, false)
        return MyViewHolder(db?.root!!)
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        db?.hero=heroList.get(position)
        holder.bind(heroList.get(position))
    }


    inner class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(hero: Hero) {
            with(view) {
                Glide
                    .with(context)
                    .load(hero.imageurl)
                    .centerCrop()
                    .placeholder(android.R.drawable.ic_btn_speak_now)
                    .into(ivProfile)

                cardView.setOnClickListener(View.OnClickListener {
                    AppAlert().showAlert(itemView,hero.toString())
                })
            }
        }
    }
}