package com.shhatrat.boilerplate_kkmvp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shhatrat.boilerplate_kkmvp.R
import com.shhatrat.boilerplate_kkmvp.ui.api.ApiActivity
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity<ApiActivity>()
    }
}
