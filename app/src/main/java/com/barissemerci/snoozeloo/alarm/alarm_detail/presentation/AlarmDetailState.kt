package com.barissemerci.snoozeloo.alarm.alarm_detail.presentation


data class AlarmDetailState(
    val alarmHour: String = "00",
    val alarmMinute: String = "00",
    val alarmName: String = "",
    val isNameEditing: Boolean = false
)
