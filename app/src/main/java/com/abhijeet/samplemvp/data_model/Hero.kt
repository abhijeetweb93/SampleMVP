package com.abhijeet.samplemvp.data_model

import android.widget.ImageView
import com.google.gson.annotations.SerializedName
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.Glide
import androidx.databinding.BindingAdapter
import java.io.Serializable


data class Hero(

    @SerializedName("name") val name: String,
    @SerializedName("realname") val realname: String,
    @SerializedName("team") val team: String,
    @SerializedName("firstappearance") val firstappearance: Int,
    @SerializedName("createdby") val createdby: String,
    @SerializedName("publisher") val publisher: String,
    @SerializedName("imageurl") val imageurl: String,
    @SerializedName("bio") val bio: String


): Serializable