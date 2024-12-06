package com.barissemerci.snoozeloo.alarm.triggered_alarm.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barissemerci.snoozeloo.alarm.core.domain.Alarm
import com.barissemerci.snoozeloo.alarm.core.domain.AlarmRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class TriggeredAlarmViewModel(
    private val alarmRepository: AlarmRepository,
    ) : ViewModel() {

    var state by mutableStateOf(TriggeredAlarmState())
        private set



  suspend fun getAlarm(id: Long) {
      Log.i("TriggeredAlarmViewModel", "getALarm()")
            alarmRepository.getAlarm(id = id).onEach { alarm ->
                state = state.copy(
                    alarmMinute = alarm.minute,
                    alarmHour = alarm.hour,
                    alarmName = alarm.name,
                    alarmId = alarm.id ?: 0
                )
                Log.i("TriggeredAlarmViewModel", "Alarm: $alarm")
            }.launchIn(viewModelScope)
    }



    fun onAction(action: TriggeredAlarmAction) {
        when (action) {
            is TriggeredAlarmAction.OnTurnOffClick -> {
                viewModelScope.launch {
                    alarmRepository.upsertAlarm(Alarm(
                        id = action.id,
                        name = state.alarmName,
                        hour = state.alarmHour,
                        minute = state.alarmMinute,
                        isEnabled = false
                    ))
                }


            }

        }
    }
}