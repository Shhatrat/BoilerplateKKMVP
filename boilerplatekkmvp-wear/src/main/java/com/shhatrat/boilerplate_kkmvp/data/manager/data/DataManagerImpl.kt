package com.shhatrat.boilerplate_kkmvp.data.manager.data

/**
 * Created by szymon on 23/12/17.
 */
class DataManagerImpl: DataManager{
    override fun getCurrentTime() =  System.currentTimeMillis()

}

class DataManagerFake: DataManager{
    override fun getCurrentTime(): Long {
        return 1000
    }
}