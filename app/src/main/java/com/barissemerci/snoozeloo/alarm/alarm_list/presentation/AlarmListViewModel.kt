package com.barissemerci.snoozeloo.alarm.alarm_list.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barissemerci.snoozeloo.alarm.alarm_list.presentation.mappers.toAlarm
import com.barissemerci.snoozeloo.alarm.alarm_list.presentation.mappers.toAlarmUi
import com.barissemerci.snoozeloo.alarm.core.domain.AlarmRepository
import com.barissemerci.snoozeloo.alarm.util.AlarmScheduler
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class AlarmListViewModel(
    private val alarmRepository: AlarmRepository,
    private val alarmScheduler: AlarmScheduler

) : ViewModel() {
    var state by mutableStateOf(AlarmListState())
        private set

    init {
        alarmRepository.getAlarms().onEach { alarms ->
            val alarmsUi = alarms.map { it.toAlarmUi() }
            state = state.copy(alarms = alarmsUi)
        }.launchIn(viewModelScope)
    }

    fun onAction(action: AlarmListAction) {
        when (action) {
            is AlarmListAction.OnAlarmClick -> {

            }

            is AlarmListAction.OnAlarmSwitchChange -> {
                state = state.copy(alarms = state.alarms.map {
                    if (it.id == action.alarm.id) {
                        it.copy(isEnabled = !action.alarm.isEnabled)
                    } else {
                        it
                    }
                })

                viewModelScope.launch {
                    alarmRepository.upsertAlarm(state.alarms.first { it.id == action.alarm.id }.toAlarm())
                }
                Log.i("AlarmListViewModel", "Alarm id: ${action.alarm.id}")
                setAlarm(action.alarm.id ?: 0)
            }

            else -> Unit
        }

    }

    fun setAlarm(alarmId: Long) {
        val alarm = state.alarms.first { it.id == alarmId }
        if (alarm.isEnabled) {
            alarmScheduler.setAlarm(alarm.hour, alarm.minute, alarm.id ?: 0)
        } else {
         //   alarmScheduler.cancelAlarm(alarm.toAlarm())
        }
    }
}