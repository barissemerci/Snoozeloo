package com.barissemerci.snoozeloo.alarm.alarm_list.presentation

import com.barissemerci.snoozeloo.alarm.alarm_list.domain.Alarm

sealed interface AlarmListAction {
    data class OnAlarmClick(val alarm: Alarm) : AlarmListAction
    data object OnAddAlarmClick : AlarmListAction
}
