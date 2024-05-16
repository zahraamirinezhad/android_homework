package com.example.androidhomework

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if(intent.action.equals("android.intent.action.ACTION_POWER_CONNECTED")){
            Toast.makeText(context,"POWER CONNECTED",Toast.LENGTH_SHORT).show()
        }else if(intent.action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")){
            Toast.makeText(context,"POWER DISCONNECTED",Toast.LENGTH_SHORT).show()
        }
    }
}