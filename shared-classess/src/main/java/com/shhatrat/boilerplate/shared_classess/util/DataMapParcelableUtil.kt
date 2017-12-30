package com.shhatrat.boilerplate.shared_classess.util

import android.os.Parcelable
import com.google.android.gms.wearable.DataMap
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 *
 * Allows to put and get [Parcelable] objects into [DataMap]
 * **USAGE:**
 *
 *
 * **Store object in DataMap:**<br></br>
 * DataMapParcelableUtils.putParcelable(dataMap, "KEY", myParcelableObject);
 *
 *
 * **Restore object from DataMap:**<br></br>
 * myParcelableObject = DataMapParcelableUtils.getParcelable(dataMap, "KEY", MyParcelableObject.CREATOR);
 *
 * I do **not recommend** to use this method - it may fail when the class that implements [Parcelable] would be updated. Use it at your own risk.
 * @author Maciej Ciemięga
 */
object DataMapParcelableUtil {

    inline fun <reified T> fromJson(dataMap: DataMap, key: String) = Gson().fromJson<T>(dataMap.getString(key), object: TypeToken<T>() {}.type)
}