package com.barissemerci.snoozeloo.alarm.alarm_detail.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class AlarmDetailViewModel : ViewModel() {
    var state by mutableStateOf(AlarmDetailState())
    private set
    fun onAction(action: AlarmDetailAction){
        when(action){
            AlarmDetailAction.OnCancelClick -> {
                println("Cancel Clicked")
            }
            is AlarmDetailAction.OnSaveClick -> {

                println("Save Clicked with ${action.alarmHour} ${action.alarmMinute} ${action.alarmName}")
            }

            AlarmDetailAction.OnChangeNameClick -> {}
            is AlarmDetailAction.OnSaveAlarmNameClick -> {
            }
        }

    }
}