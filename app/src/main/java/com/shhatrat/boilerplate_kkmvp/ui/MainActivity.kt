package com.shhatrat.boilerplate_kkmvp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.shhatrat.boilerplate_kkmvp.R
import com.shhatrat.boilerplate_kkmvp.ui.ex.ExActivity
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity<ExActivity>()
//        startService<MainService>()
//        button.setOnClickListener {
//            toast(isRunning<MainService>().toString())
//        }
    }
}
