package com.abhijeet.samplemvp.base

import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.abhijeet.samplemvp.logger.Logger
import androidx.annotation.LayoutRes
import android.os.Bundle
import android.view.ViewGroup
import androidx.annotation.Nullable
import com.abhijeet.samplemvp.R
import com.abhijeet.samplemvp.databinding.ActivityBaseBinding
import com.abhijeet.samplemvp.view.activity.MainActivity


open abstract class BaseActivity<P : BasePresenter<out IBaseView, out BaseModel>> : AppCompatActivity() {



    private val TAG = MainActivity::class.java.simpleName

    //protected var progressBar: ProgressBar? = null
    protected var presenter: P? = null
    protected var baseBinding: ActivityBaseBinding? = null


    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseBinding = DataBindingUtil.setContentView(this, R.layout.activity_base)
        Logger().log(TAG, "onCreate Method")
        if (presenter == null) {
            presenter = initPresenter()
        }
    }

    protected fun <T : ViewDataBinding> putContentView(@LayoutRes resId: Int): T {
        val viewGroup: ViewGroup = baseBinding?.layoutContainer!!
        return DataBindingUtil.inflate(layoutInflater, resId, viewGroup, true)
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter?.unSubscribe()
        Logger().log(TAG, "onDestroy Method")

    }

    fun showProgressBar() {
        baseBinding?.progressBar?.visibility = VISIBLE
    }

    fun hideProgressBar() {
        baseBinding?.progressBar?.visibility = INVISIBLE
    }

    protected abstract fun initPresenter(): P


}