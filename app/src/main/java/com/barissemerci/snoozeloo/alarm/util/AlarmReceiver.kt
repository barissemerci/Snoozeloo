package com.barissemerci.snoozeloo.alarm.util

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        val alarmId = intent?.getLongExtra("alarmId", 0)
        Log.i("AlarmReceiver", "Alarm id: $alarmId")

        val deeplinkUri = Uri.parse("barissemerci://triggered_alarm?alarmId=$alarmId")

        val deepLinkIntent = Intent(Intent.ACTION_VIEW, deeplinkUri).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        }

        context.startActivity(deepLinkIntent)
    }
}




