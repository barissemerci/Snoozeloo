package com.barissemerci.snoozeloo.alarm.alarm_list.presentation.models

data class AlarmUi(
    val id: Long?,
    val title: String,
    val hour: Int,
    val minute : Int,
    val amPm : String,
    val alarmInText: String,
    val isEnabled: Boolean
)


