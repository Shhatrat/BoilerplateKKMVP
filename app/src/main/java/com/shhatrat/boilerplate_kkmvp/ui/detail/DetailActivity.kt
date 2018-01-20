package com.shhatrat.boilerplate_kkmvp.ui.detail

import android.os.Bundle
import com.shhatrat.boilerplate.shared_classess.model.BasicStation
import com.shhatrat.boilerplate.shared_classess.model.StationData
import com.shhatrat.boilerplate.shared_classess.model.StationSensor
import com.shhatrat.boilerplate_kkmvp.R
import com.shhatrat.boilerplate_kkmvp.di.baseUi.android.BaseActivity
import com.shhatrat.boilerplate_kkmvp.util.externsions.simpleVisibility
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.ext.android.inject

class DetailActivity : BaseActivity(), DetailContract.IView {
    override fun wearEnable(b: Boolean) {
        wearBtn.simpleVisibility(b)
    }

    companion object {
        val BACIC = "BACIC"
    }

    override fun updateView(pair: Pair<StationData?, List<StationSensor>?>) {
       detailTV.text = "${pair.first?.c6h6CalcDate?:"No data"} - ${pair.first?.c6h6IndexLevel?:"No data"}"
    }

    private val presenter by inject<DetailContract.IPresenter<DetailContract.IView>>()

    override fun attachPresenter() {
        presenter.attachView(this)
    }

    override fun detachPresenter() {
        presenter.detachView()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val basicStation = intent.getParcelableExtra<BasicStation>(BACIC)
        presenter.checkWearEnable()
        basicStation.let {
            presenter.updateData(it.id)
            initBasics(basicStation)
            wearBtn.setOnClickListener { presenter.sendToWear(it.id) }
        }
    }

    private fun initBasics(basicStation: BasicStation){
        cityTV.text = basicStation.addressStreet
    }
}
