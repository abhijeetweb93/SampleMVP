package com.abhijeet.samplemvp.base

import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.abhijeet.samplemvp.R

open class BaseActivity() : AppCompatActivity() {

    private var progressBar: ProgressBar? = null;

    override fun setContentView(layoutResID: Int) {
        val coordinatorLayout: RelativeLayout = layoutInflater.inflate(R.layout.activity_base, null) as RelativeLayout
        val activityContainer: FrameLayout = coordinatorLayout.findViewById(R.id.layout_container)
        progressBar = coordinatorLayout.findViewById(R.id.progressBar) as ProgressBar


        layoutInflater.inflate(layoutResID, activityContainer, true)

        super.setContentView(coordinatorLayout)
    }

    fun showProgressBar() {
        progressBar?.visibility = VISIBLE
    }

    fun hideProgressBar() {
        progressBar?.visibility = INVISIBLE
    }
}