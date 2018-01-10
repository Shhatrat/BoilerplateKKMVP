package com.shhatrat.boilerplate_kkmvp.ui.list.adapter

import android.content.Context
import android.support.constraint.ConstraintLayout
import com.shhatrat.boilerplate_kkmvp.R
import kotlinx.android.synthetic.main.row_basic_station.view.*

/**
 * Created by szymon on 10/01/18.
 */
class BasicStationRow(context: Context): ConstraintLayout(context){

    init {
        init()
    }

    private fun init(){
        ConstraintLayout.inflate(context, R.layout.row_basic_station, this)
        isClickable = true
        isFocusable = true
    }

    var text: String?=""
        set(value){
            field = value
            descriptionTV.text = value
        }

    var fav: Boolean=false
        set(value){
            field = value
            favCB.isChecked = value
        }

    var changeFun: ((checkted: Boolean) ->Unit)? = null
        set(value){
            field = value
            favCB.setOnCheckedChangeListener { _, isChecked -> value?.invoke(isChecked) }
    }
    var onClick: (() -> Unit)? = null
        set(value){
            field = value
            descriptionTV.setOnClickListener { onClick?.invoke() }
        }
}