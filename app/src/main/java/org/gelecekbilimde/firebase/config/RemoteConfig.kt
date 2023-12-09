package org.gelecekbilimde.firebase.config

import android.content.Context
import android.content.pm.PackageInfo
import android.util.Log
import com.google.gson.Gson

class RemoteConfig {

    fun isForceUpdate(context: Context, callback: (Boolean) -> Unit) {
        RemoteConfigData("force_update").getRemoteConfig { forceUpdateData ->
            val remoteJson = Gson().toJson(forceUpdateData)
            val isForceUpdateEnabled = remoteJson.toBoolean()
            Log.d("remoteConfigData", isForceUpdateEnabled.toString())

            if (isForceUpdateEnabled) {
                RemoteConfigData("force_update_version").getRemoteConfig { remoteConfigVersionName ->
                    val pInfo: PackageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
                    val versionName = pInfo.versionName
                    val isForceUpdate = remoteConfigVersionName.toString() != versionName
                    callback(isForceUpdate)
                }
            } else {
                callback(false)
            }
        }
    }

}