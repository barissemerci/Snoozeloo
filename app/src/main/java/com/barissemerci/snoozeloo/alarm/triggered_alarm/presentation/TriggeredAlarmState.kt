package com.barissemerci.snoozeloo.alarm.triggered_alarm.presentation

data class TriggeredAlarmState(
    val alarmId: Long = 0,
    val alarmName: String = "",
    val alarmHour: Int = 0,
    val alarmMinute: Int = 0,
)
