package com.shhatrat.boilerplate_kkmvp.data.repository

import com.shhatrat.boilerplate_kkmvp.util.base.Preferences


/**
 * Created by szymon on 24/12/17.
 */
class SettingsRepositiory : Preferences(){

    var wear by booleanPref()
    var backgroundService by booleanPref()
    var updateEveryTime by booleanPref()
    var favourites by stringSetPref()
}