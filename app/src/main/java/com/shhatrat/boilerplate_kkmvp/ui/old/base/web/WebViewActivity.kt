package com.shhatrat.boilerplate_kkmvp.ui.old.base.web

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.shhatrat.boilerplate_kkmvp.R
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {

    companion object {
        val INTENT_KEY= "INTENT_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val url = intent.getStringExtra(INTENT_KEY)
        if(url==null)
            finish()
        setContentView( R.layout.activity_web_view)
        staticVW.loadUrl(url)
    }
}
