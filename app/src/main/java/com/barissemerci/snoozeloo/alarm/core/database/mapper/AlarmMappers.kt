package com.barissemerci.snoozeloo.alarm.core.database.mapper

import com.barissemerci.snoozeloo.alarm.core.domain.Alarm
import com.barissemerci.snoozeloo.alarm.core.database.entity.AlarmEntity

fun Alarm.toAlarmEntity() : AlarmEntity {
    return AlarmEntity(hour = hour, minute = minute, name = name, id = id ?: 0)
}

fun AlarmEntity.toAlarm() : Alarm{
    return Alarm(id = id, name = name, hour = hour, minute = minute)
}