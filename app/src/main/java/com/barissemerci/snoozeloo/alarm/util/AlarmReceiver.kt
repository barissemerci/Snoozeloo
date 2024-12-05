package com.barissemerci.snoozeloo.alarm.util

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.Uri

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        val alarmId = intent?.getIntExtra("alarm_id", 0) ?: 0

        val deeplinkUri = Uri.parse("barissemerci://triggered_alarm")

        val deepLinkIntent = Intent(Intent.ACTION_VIEW, deeplinkUri).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        }

        context.startActivity(deepLinkIntent)
    }
}




