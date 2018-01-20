package com.shhatrat.boilerplate_kkmvp.ui.detail

import android.os.Bundle
import com.shhatrat.boilerplate.shared_classess.model.BasicStation
import com.shhatrat.boilerplate.shared_classess.model.StationData
import com.shhatrat.boilerplate.shared_classess.model.StationSensor
import com.shhatrat.boilerplate_kkmvp.R
import com.shhatrat.boilerplate_kkmvp.di.baseUi.android.BaseActivity
import com.shhatrat.boilerplate_kkmvp.ui.old.base.adapter.simple.SimpleListAdapter
import com.shhatrat.boilerplate_kkmvp.ui.old.base.adapter.simple.SimpleListModel
import com.shhatrat.boilerplate_kkmvp.util.externsions.prepareSimple
import com.shhatrat.boilerplate_kkmvp.util.externsions.simpleVisibility
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.ext.android.inject

class DetailActivity : BaseActivity(), DetailContract.IView {

    companion object {
        val BASIC = "BASIC"
    }

    private val presenter by inject<DetailContract.IPresenter<DetailContract.IView>>()
    private val adapter by inject<SimpleListAdapter>()

    override fun wearEnable(b: Boolean) {
        wearBtn.simpleVisibility(b)
    }


    override fun updateView(pair: Pair<StationData?, List<StationSensor>?>) {

        val list = pair.second?.filter { it.param!=null }?.map { SimpleListModel("${it.param?.paramName} ${it.param?.paramFormula}") }
        if(list?.isNotEmpty()==true) {
            adapter.list += list
            adapter.notifyDataSetChanged()
        }
    }

    override fun attachPresenter() {
        presenter.attachView(this)
    }

    override fun detachPresenter() {
        presenter.detachView()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val basicStation = intent.getParcelableExtra<BasicStation>(BASIC)
        presenter.checkWearEnable()
        initAdapter()
        basicStation.let {
            presenter.updateData(it.id)
            initBasics(basicStation)
            wearBtn.setOnClickListener { presenter.sendToWear(it.id) }
        }
    }

    private fun initAdapter(){
        adapter.list = listOf()
        detailsRV.adapter = adapter
        detailsRV.prepareSimple(this)

    }

    private fun initBasics(basicStation: BasicStation){
        val list = listOf(
                SimpleListModel(basicStation.stationName),
                SimpleListModel(basicStation.addressStreet),
                SimpleListModel(basicStation.city?.name),
                SimpleListModel(basicStation.id.toString())
        )
        adapter.list = list
        adapter.notifyDataSetChanged()
    }
}
