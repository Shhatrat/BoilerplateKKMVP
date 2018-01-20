package com.shhatrat.boilerplate_kkmvp.ui.list.fragment


import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shhatrat.boilerplate.shared_classess.model.BasicStation
import com.shhatrat.boilerplate_kkmvp.R
import com.shhatrat.boilerplate_kkmvp.di.baseUi.android.BaseFragment
import com.shhatrat.boilerplate_kkmvp.ui.detail.DetailActivity
import com.shhatrat.boilerplate_kkmvp.ui.list.adapter.BasicStationAdapter
import kotlinx.android.synthetic.main.fragment_list.*
import org.jetbrains.anko.startActivity
import org.koin.android.ext.android.inject

class ListFragment : BaseFragment(), ListContract.IView {


    private val presenter by inject<ListContract.IPresenter<ListContract.IView>>(intentKey)
    private val adapter by inject<BasicStationAdapter>()

    override fun attachPresenter() {
        presenter.attachView(this)
    }

    override fun detachPresenter() {
        presenter.detachView()
    }

    override fun setList(list: List<Pair<BasicStation, Boolean>>) {
        adapter.list = list
        adapter.notifyDataSetChanged()
    }

    override fun updateList(item: BasicStation) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getList()
        preapreRV()
    }

    private fun preapreRV(){
        stationRV.adapter = adapter
        adapter.list = listOf()
        stationRV.layoutManager = LinearLayoutManager(this.context)
        stationRV.hasFixedSize()

        adapter.addToFav  = this::addToFavourites
        adapter.removeFromFav  = this::removeFromFavourites
        adapter.clickFun = { activity?.startActivity<DetailActivity>(DetailActivity.BACIC to it)}

        val divider = DividerItemDecoration(stationRV.context, DividerItemDecoration.VERTICAL)
        val dividerDrawable = ContextCompat.getDrawable(this.context, R.drawable.divider)
        if(dividerDrawable!=null)
            divider.setDrawable(dividerDrawable)
        stationRV.addItemDecoration(divider)
    }

    private fun addToFavourites(id: Int) {
        presenter.addToFavourite(id)
    }
    private fun removeFromFavourites(id: Int) {
        presenter.removeFromFavourite(id)
    }

}
