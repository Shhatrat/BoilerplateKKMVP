package com.shhatrat.boilerplate_kkmvp.ui

//import com.betomaluje.android.kyky.Kyky
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.shhatrat.boilerplate_kkmvp.R
import com.shhatrat.boilerplate_kkmvp.ui.old.api.ApiActivity
import com.shhatrat.boilerplate_kkmvp.ui.settings.SettingsActivity
import org.jetbrains.anko.startActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity<SettingsActivity>()
    }
}
