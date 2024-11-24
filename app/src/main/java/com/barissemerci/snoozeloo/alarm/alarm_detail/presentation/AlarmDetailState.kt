package com.barissemerci.snoozeloo.alarm.alarm_detail.presentation


data class AlarmDetailState(
    val alarmHour: String = "",
    val alarmMinute: String = "",
    val alarmName: String = "",
    val isNameEditing: Boolean = false
)
