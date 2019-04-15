package com.hyun.android.interpolatorsample

fun <T> isLong(param: T): Boolean {
    try {
        param.toString().toLong()
        return true
    } catch (e: Exception) {
        e.printStackTrace()
    }

    return false
}