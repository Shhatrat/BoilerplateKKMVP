package com.shhatrat.boilerplate_kkmvp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shhatrat.boilerplate_kkmvp.R
import com.shhatrat.boilerplate_kkmvp.service.MainService
import com.shhatrat.boilerplate_kkmvp.ui.ex.ExActivity
import com.shhatrat.boilerplate_kkmvp.util.service.isRunning
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity<ExActivity>()
//        startService<MainService>()
        button.setOnClickListener {
            toast(isRunning<MainService>().toString())
        }
    }
}
