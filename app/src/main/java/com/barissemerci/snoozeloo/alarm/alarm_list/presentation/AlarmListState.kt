package com.barissemerci.snoozeloo.alarm.alarm_list.presentation

import com.barissemerci.snoozeloo.alarm.alarm_list.presentation.models.AlarmUi

data class AlarmListState(
    val alarms : List<AlarmUi> = emptyList(),
    val isLoading : Boolean = false,
    val selectedAlarm : AlarmUi? = null,
    )
