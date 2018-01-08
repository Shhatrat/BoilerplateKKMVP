package com.shhatrat.boilerplate.shared_classess.model

/**
 * Created by szymon on 8/01/18.
 */
data class StationSensor(val id: Number?, val stationId: Number?, val param: Param?, val sensorDateStart: String?, val sensorDateEnd: String?)

data class Param(val paramName: String?, val paramFormula: String?, val paramCode: String?, val idParam: Number?)