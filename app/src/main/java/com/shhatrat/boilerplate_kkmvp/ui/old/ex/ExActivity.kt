package com.shhatrat.boilerplate_kkmvp.ui.old.ex

import android.os.Bundle
import android.util.Log
import com.shhatrat.boilerplate_kkmvp.R
import com.shhatrat.boilerplate_kkmvp.di.baseUi.android.BaseActivity
import com.shhatrat.boilerplate_kkmvp.di.modules.ManagerModule
import kotlinx.android.synthetic.main.activity_ex.*
import org.koin.android.ext.android.inject

class ExActivity : BaseActivity(), ExContract.IView {

    companion object {
        var INJECT_NAME = ManagerModule.FAKE
    }

    private val presenter by inject<ExContract.IPresenter<ExContract.IView>>()

    override fun attachPresenter() {
        presenter.attachView(this)
    }

    override fun detachPresenter() {
        presenter.detachView()
    }

    override fun showTime(time: String) {
//        toast(time)
        Log.d("dddd", time)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex)
        button2.setOnClickListener { presenter.getTime() }
    }
}