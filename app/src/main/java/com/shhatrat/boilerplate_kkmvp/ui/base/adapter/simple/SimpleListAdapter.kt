package com.shhatrat.boilerplate_kkmvp.ui.base.adapter.simple

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by szymon on 24/12/17.
 */
class SimpleListAdapter : RecyclerView.Adapter<SimpleListAdapter.ViewHolder>(){

    lateinit var list: List<SimpleListModel>

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.view) {
            text = list[position].text
            imageDrawableId = list[position].imageId
            setOnClickListener { list[position].onClickFun.invoke() }
        }
    }

    override fun getItemCount() = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder? {
        val rootView = SimpleTextRow(parent.context)
        val lp = RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        rootView.layoutParams = lp
        return ViewHolder(rootView)
    }

    class ViewHolder(val view: SimpleTextRow) : RecyclerView.ViewHolder(view)
}