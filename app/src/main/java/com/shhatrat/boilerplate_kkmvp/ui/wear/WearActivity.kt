package com.shhatrat.boilerplate_kkmvp.ui.wear

import android.os.Bundle
import com.shhatrat.boilerplate_kkmvp.R
import com.shhatrat.boilerplate_kkmvp.di.baseUi.android.BaseActivity
import org.jetbrains.anko.toast
import org.koin.android.ext.android.inject

class WearActivity : BaseActivity(), WearContract.IView {

    override fun getMessage(input: String) {
        toast(input)
    }

    override fun attachPresenter() {
        presenter.attachView(this)
    }
    override fun detachPresenter() {
        presenter.detachView()
    }

    private val presenter by inject<WearContract.IPresenter<WearContract.IView>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wear)
    }
}
