/*
 * Copyright (C) 2017. Avalon information System : Project ASMAN
 */

package com.abhijeet.samplemvp.app_util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo


open class NetUtil {


    /**
     * Determine whether the network is connected
     *
     * @param context Context
     * @return Network is connected
     */
    fun isConnected(context: Context): Boolean {

        val connectivity =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (null != connectivity) {
            val info = connectivity.activeNetworkInfo
            if (null != info && info.isConnected) {
                if (info.state == NetworkInfo.State.CONNECTED) {
                    return true
                }
            }
        }
        return false
    }

    /**
     * To determine whether it is wifi connection
     *
     * @param context Context
     * @return Whether it is wifi connection
     */
    fun isWifi(context: Context): Boolean {
        val cm = context
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm != null && cm.activeNetworkInfo!!.type == ConnectivityManager.TYPE_WIFI

    }


}
