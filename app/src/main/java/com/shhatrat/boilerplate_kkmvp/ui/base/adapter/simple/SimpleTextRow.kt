package com.shhatrat.boilerplate_kkmvp.ui.base.adapter.simple

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import com.shhatrat.boilerplate_kkmvp.R
import com.shhatrat.boilerplate_kkmvp.util.externsions.load
import kotlinx.android.synthetic.main.row_simple_text.view.*

/**
 * Created by szymon on 24/12/17.
 */
class SimpleTextRow(context: Context) : RelativeLayout(context) {

    private fun init() {
        LinearLayout.inflate(context, R.layout.row_simple_text, this)
        isClickable = true
        isFocusable = true
    }

    var text: String? = ""
        set(value) {
            field = value
            mainTextTV.text = value
        }

    var imageUrl: String? =""
        set(value) {
            field = value
            imageIV.load(value)
        }

    var imageDrawable: Drawable?=null
        set(value) {
            field = value
            imageIV.setImageDrawable(value)
        }
    var imageDrawableId: Int?=null
        set(value) {
            field = value
            if(imageDrawableId!=null)
               imageIV.setImageDrawable(ContextCompat.getDrawable(context, imageDrawableId!!))
        }

    init {
        init()
    }
}