package com.barissemerci.snoozeloo.alarm.triggered_alarm.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.barissemerci.snoozeloo.ui.theme.SnoozelooTheme
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class AlarmActivity(
) : ComponentActivity() {
     private val triggeredAlarmViewModel : TriggeredAlarmViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
        val uri = intent?.data
        val alarmId = uri?.getQueryParameter("alarmId")?.toLongOrNull()

        if (alarmId != null) {
            Log.i("AlarmActivity", "Alarm id: $alarmId")
            lifecycleScope.launch {
                triggeredAlarmViewModel.getAlarm(alarmId)

            }
        }

        setContent {
            SnoozelooTheme {
                Scaffold {
                    TriggeredAlarmScreenRoot(
                        modifier = Modifier.padding(it),
                        viewModel = triggeredAlarmViewModel,
                        onTurnOffClick = {
                          finish()
                        }
                    )
                }
            }

        }


    }
}
