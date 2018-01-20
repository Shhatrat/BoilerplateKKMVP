package com.shhatrat.boilerplate_kkmvp.ui.detail

import android.os.Bundle
import com.shhatrat.boilerplate.shared_classess.model.BasicStation
import com.shhatrat.boilerplate_kkmvp.R
import com.shhatrat.boilerplate_kkmvp.di.baseUi.android.BaseActivity
import org.koin.android.ext.android.inject

class DetailActivity : BaseActivity(), DetailContract.IView {

    private val presenter by inject<DetailContract.IPresenter<DetailContract.IView>>()

    override fun attachPresenter() {
        presenter.attachView(this)
    }

    override fun detachPresenter() {
        presenter.detachView()
    }
    override fun updateView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        val basic = "basic"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val basicStation = intent.getParcelableExtra<BasicStation>(basic)
        basicStation.let { presenter.updateData(it.id) }
    }
}
