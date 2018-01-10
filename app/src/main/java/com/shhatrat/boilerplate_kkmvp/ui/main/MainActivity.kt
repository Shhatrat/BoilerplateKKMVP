package com.shhatrat.boilerplate_kkmvp.ui.main

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import co.zsmb.materialdrawerkt.builders.drawer
import co.zsmb.materialdrawerkt.draweritems.badgeable.primaryItem
import co.zsmb.materialdrawerkt.draweritems.badgeable.secondaryItem
import co.zsmb.materialdrawerkt.draweritems.divider
import com.shhatrat.boilerplate_kkmvp.R
import com.shhatrat.boilerplate_kkmvp.ui.list.fragment.ListFragment
import com.shhatrat.boilerplate_kkmvp.ui.settings.SettingsActivity
import com.shhatrat.boilerplate_kkmvp.util.externsions.replace
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        prepareDrawer()

    }

    private fun prepareDrawer(){
        drawer {
            toolbar = toolbarAc
            primaryItem("Favourite") {}
            primaryItem("All") {
                onClick { _ ->
                    replace<ListFragment>(R.id.frame)
                    false
                }
            }
            divider {}
            secondaryItem("Settings") {
                selectable = false
                onClick { _ -> startActivity<SettingsActivity>() ; false }
            }
        }
    }
}
