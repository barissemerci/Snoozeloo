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
        isEnabled = isEnabled,
        id = id
    )
}

fun AlarmUi.toAlarm() : Alarm {
    return Alarm(
        name = title,
        hour = hour,
        minute = minute,
        isEnabled = isEnabled,
        id = id
    )
}