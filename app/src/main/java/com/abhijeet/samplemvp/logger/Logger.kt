/*
 * Copyright (C) 2017. Avalon information System : Project ASMAN
 */

package com.abhijeet.samplemvp.logger

import android.util.Log

import com.abhijeet.samplemvp.BuildConfig

/**
 * Logger class to log system level events
 */

class Logger {
    /**
     * @param tag     is the log generator class name
     * @param log     event text
     * @param logType type of log event
     * DEBUG
     * ERROR
     * or INFO
     */
    @JvmOverloads
    fun log(tag: String, log: String, logType: LogType = LogType.DEBUG) {

        if (BuildConfig.DEBUG) {
            when (logType) {
                Logger.LogType.ERROR -> {
                    Log.e(tag, "e: $log")
                }
                Logger.LogType.INFO -> {
                    Log.i(tag, "i: $log")
                }
                else -> {
                    Log.d(tag, "d: $log")
                }
            }
        }
    }

    /**
     * LogType class to differentiate
     * DEBUG
     * ERROR
     * INFO
     */
    enum class LogType {
        DEBUG, ERROR, INFO
    }
}
/**
 * @param tag is the  log generator class name
 * @param log event text
 */
