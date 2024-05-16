package com.example.androidhomework

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class BluetoothStatusWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    override fun doWork(): Result {
        val bluetoothAdapter = android.bluetooth.BluetoothAdapter.getDefaultAdapter()

        val bluetoothMode = when (bluetoothAdapter?.state) {
            android.bluetooth.BluetoothAdapter.STATE_OFF -> "OFF"
            android.bluetooth.BluetoothAdapter.STATE_ON -> "ON"
            else -> "UNKNOWN"
        }

        Log.i("BluetoothStatusWorker", "Bluetooth mode: $bluetoothMode")

        return Result.success()
    }
}