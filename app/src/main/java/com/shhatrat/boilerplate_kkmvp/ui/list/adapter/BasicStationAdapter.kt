package com.shhatrat.boilerplate_kkmvp.ui.list.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.shhatrat.boilerplate.shared_classess.model.BasicStation

/**
 * Created by szymon on 10/01/18.
 */
class BasicStationAdapter : RecyclerView.Adapter<BasicStationAdapter.ViewHolder>(){

    lateinit var list: List<Pair<BasicStation, Boolean>>
    lateinit var addToFav: (id: Int) -> Unit
    lateinit var removeFromFav: (id: Int) -> Unit

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        with(holder!!.view){
            val item = list[position]
            text = item.first.stationName
            fav = item.second
            pp = {
                if(it)
                    addToFav.invoke(item.first.id)
                else
                    removeFromFav.invoke(item.first.id)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val rootView = BasicStationRow(parent!!.context)
        val lp = RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        rootView.layoutParams = lp
        return ViewHolder(rootView)
    }

    override fun getItemCount()= list.size

    class ViewHolder(val view: BasicStationRow) : RecyclerView.ViewHolder(view)
}