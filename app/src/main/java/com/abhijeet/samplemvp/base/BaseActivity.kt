package com.abhijeet.samplemvp.base

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.abhijeet.samplemvp.R


open abstract class BaseActivity<P : BasePresenter<IBaseView,BaseModel>> : AppCompatActivity() {

    protected var progressBar: ProgressBar? = null
    protected var presenter: P? = null


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        if (onCreatePresenter() != null) {
            presenter = onCreatePresenter()
        }
    }

    override fun setContentView(layoutResID: Int) {
        val coordinatorLayout: RelativeLayout =
            layoutInflater.inflate(R.layout.activity_base, null) as RelativeLayout
        val activityContainer: FrameLayout = coordinatorLayout.findViewById(R.id.layout_container)
        progressBar = coordinatorLayout.findViewById(R.id.progressBar) as ProgressBar


        layoutInflater.inflate(layoutResID, activityContainer, true)

        super.setContentView(coordinatorLayout)
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter?.unSubscribe()

    }

    fun showProgressBar() {
        progressBar?.visibility = VISIBLE
    }

    fun hideProgressBar() {
        progressBar?.visibility = INVISIBLE
    }

    protected abstract fun onCreatePresenter(): P
}