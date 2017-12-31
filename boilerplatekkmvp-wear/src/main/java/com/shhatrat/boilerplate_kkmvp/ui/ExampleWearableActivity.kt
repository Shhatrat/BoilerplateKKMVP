package com.shhatrat.boilerplate_kkmvp.ui

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import com.shhatrat.boilerplate_kkmvp.R

class ExampleWearableActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_wearable)
    }
}
