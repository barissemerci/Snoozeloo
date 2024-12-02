package com.barissemerci.snoozeloo.alarm.alarm_list.presentation.mappers

import com.barissemerci.snoozeloo.alarm.alarm_list.presentation.models.AlarmUi
import com.barissemerci.snoozeloo.alarm.core.domain.Alarm

fun Alarm.toAlarmUi() : AlarmUi {
    return AlarmUi(
        title = name,
        hour = hour,
        minute = minute,
        amPm = "AM",
        alarmInText = "Alarm in 5 hours",
        isSwitchOn = true
    )
}