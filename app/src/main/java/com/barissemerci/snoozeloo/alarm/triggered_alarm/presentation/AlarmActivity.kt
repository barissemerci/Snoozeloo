package com.barissemerci.snoozeloo.alarm.triggered_alarm.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.barissemerci.snoozeloo.ui.theme.SnoozelooTheme

class AlarmActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()


        setContent {
            SnoozelooTheme {
                Scaffold {
                    TriggeredAlarmScreenRoot(
                        modifier = Modifier.padding(it)
                    )
                }
            }

        }

        val uri = intent?.data
        val alarmId = uri?.getQueryParameter("alarmId")?.toIntOrNull()

        if (alarmId != null) {
        }
    }
}
