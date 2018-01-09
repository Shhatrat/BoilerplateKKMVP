package com.shhatrat.boilerplate_kkmvp.ui.main

import android.app.Activity
import android.os.Bundle
import co.zsmb.materialdrawerkt.builders.drawer
import co.zsmb.materialdrawerkt.draweritems.badgeable.primaryItem
import co.zsmb.materialdrawerkt.draweritems.badgeable.secondaryItem
import co.zsmb.materialdrawerkt.draweritems.divider
import com.shhatrat.boilerplate_kkmvp.R
import com.shhatrat.boilerplate_kkmvp.ui.settings.SettingsActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        prepareDrawer()

    }

    private fun prepareDrawer(){
        drawer {
            toolbar = toolbarAc
            primaryItem("Favourite") {}
            primaryItem("All") {}
            divider {}
            secondaryItem("Settings") {
                selectable = false
                onClick { _ -> startActivity<SettingsActivity>() ; false }
            }
        }
    }
}
