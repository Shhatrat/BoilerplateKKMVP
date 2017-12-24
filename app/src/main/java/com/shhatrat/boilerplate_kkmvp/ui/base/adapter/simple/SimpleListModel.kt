package com.shhatrat.boilerplate_kkmvp.ui.base.adapter.simple

/**
 * Created by szymon on 24/12/17.
 */
data class SimpleListModel(
        val text: String,
        val imageId: Int?,
        val onClickFun: () -> Unit
)