/*
 * Copyright (C) 2017. Avalon information System : Project ASMAN
 */

package com.abhijeet.samplemvp.api


import com.abhijeet.samplemvp.data_model.Hero
import com.abhijeet.samplemvp.data_model.TokenValue
import io.reactivex.Observable
import retrofit2.Call

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.GET



/**
 * Base class for API URL and parameters
 */
interface ApiService {

    companion object {
        val BASE_URL = "https://simplifiedcoding.net/demos/"
    }


    @Headers("Accept: application/json", "Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("users/token")
    fun getToken(@Field("username") username: String, @Field("password") password: String): Observable<TokenValue>

    @GET("marvel")
    fun getHeroes(): Observable<List<Hero>>



}
