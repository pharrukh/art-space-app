package com.normuradov.artspaceapp

import android.content.Context
import android.content.res.Resources

fun Context.resIdByName(resIdName: String?, resType: String = "drawable"): Int {
    resIdName?.let {
        return resources.getIdentifier(it, resType, packageName)
    }
    throw Resources.NotFoundException()
}