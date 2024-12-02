package com.barissemerci.snoozeloo.alarm.alarm_detail.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barissemerci.snoozeloo.alarm.core.domain.Alarm
import com.barissemerci.snoozeloo.alarm.core.domain.AlarmRepository
import kotlinx.coroutines.launch


class AlarmDetailViewModel(
    private val alarmRepository: AlarmRepository
) : ViewModel() {
    var state by mutableStateOf(AlarmDetailState())
        private set

    fun onAction(action: AlarmDetailAction) {
        when (action) {
            AlarmDetailAction.OnCancelClick -> {
                println("Cancel Clicked")
            }

            is AlarmDetailAction.OnSaveClick -> {
                saveAlarm()
                println("Save Clicked with ${action.alarmHour} ${action.alarmMinute} ${action.alarmName}")
            }

            AlarmDetailAction.OnNameClick -> {
                state = state.copy(isNameEditing = !state.isNameEditing)
            }

            is AlarmDetailAction.OnSaveNameClick -> {
                state = state.copy(alarmName = action.alarmName, isNameEditing = false)
            }

            is AlarmDetailAction.OnHourChange -> {
                val number = action.hour.toIntOrNull()
                if (action.hour.isEmpty()) {
                    state = state.copy(alarmHour = action.hour)
                } else if (number != null && number in 0..23) {
                    state = state.copy(alarmHour = action.hour)
                }
            }

            is AlarmDetailAction.OnMinuteChange -> {
                val number = action.minute.toIntOrNull()
                if (action.minute.isEmpty()) {
                    state = state.copy(alarmMinute = action.minute)
                } else if (number != null && number in 0..59) {
                    state = state.copy(alarmMinute = action.minute)
                }
            }

        }
    }

    fun saveAlarm() {
        val alarm = Alarm(
            name = state.alarmName,
            hour = state.alarmHour.toInt(),
            minute = state.alarmMinute.toInt(),
            id = null
        )
        viewModelScope.launch {
            alarmRepository.upsertAlarm(
                alarm
            )
        }

    }
}