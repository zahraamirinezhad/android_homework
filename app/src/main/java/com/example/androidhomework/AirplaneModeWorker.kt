package com.example.androidhomework

import android.content.Context
import android.os.Build
import android.provider.Settings
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class AirplaneModeWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    override fun doWork(): Result {
        // Check airplane mode status
        val isAirplaneModeOn = isAirplaneModeOn(applicationContext)

        // Log the status
        Log.i("AirplaneModeWorker", "Airplane mode is ${if (isAirplaneModeOn) "ON" else "OFF"}")

        return Result.success()
    }

    private fun isAirplaneModeOn(context: Context): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return Settings.System.getInt(
                context.contentResolver,
                Settings.System.AIRPLANE_MODE_ON,
                0
            ) != 0
        } else {
            return Settings.Global.getInt(
                context.contentResolver,
                Settings.Global.AIRPLANE_MODE_ON,
                0
            ) != 0
        }
    }
}
