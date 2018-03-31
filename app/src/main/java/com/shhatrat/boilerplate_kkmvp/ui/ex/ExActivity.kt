package com.shhatrat.boilerplate_kkmvp.ui.ex

import android.os.Bundle
import com.shhatrat.boilerplate_kkmvp.R
import com.shhatrat.boilerplate_kkmvp.di.baseUi.android.BaseActivity
import com.shhatrat.boilerplate_kkmvp.di.modules.InjectionType.FAKE
import kotlinx.android.synthetic.main.activity_ex.*
import org.jetbrains.anko.toast
import org.koin.android.ext.android.inject

class ExActivity : BaseActivity(), ExContract.IView {

    companion object {
        var INJECT_NAME = FAKE
    }

    private val presenter by inject<ExContract.IPresenter<ExContract.IView>>()

    override fun attachPresenter() {
        presenter.attachView(this)
    }

    override fun detachPresenter() {
        presenter.detachView()
    }

    override fun showTime(time: String) {
        toast(time)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex)
        button2.setOnClickListener { presenter.getTime() }
    }
}
