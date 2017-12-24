package com.shhatrat.boilerplate_kkmvp.data.repository

import com.shhatrat.boilerplate_kkmvp.util.base.Preferences


/**
 * Created by szymon on 24/12/17.
 */
class UserRepositiory: Preferences(){

    var name by stringPref()
}