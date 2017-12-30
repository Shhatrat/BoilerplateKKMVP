package com.shhatrat.boilerplate_kkmvp

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import com.google.android.gms.wearable.MessageApi
import com.patloew.rxwear.RxWear
import com.patloew.rxwear.transformers.MessageEventGetDataMap
import com.shhatrat.boilerplate.shared_classess.Constraints
import com.shhatrat.boilerplate.shared_classess.model.Person
import com.shhatrat.boilerplate.shared_classess.util.DataMapParcelableUtil.fromJson
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : WearableActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enables Always-on
        setAmbientEnabled()

        val rxWear = RxWear(this)

        rxWear.message().listen(Constraints.sendPersonPath, MessageApi.FILTER_LITERAL)
                .compose(MessageEventGetDataMap.noFilter())
                .subscribe({ dataMap ->
                    val person = fromJson<Person>(dataMap, Constraints.person)
                    text.text = person.name
                }, {

                })
    }
}
