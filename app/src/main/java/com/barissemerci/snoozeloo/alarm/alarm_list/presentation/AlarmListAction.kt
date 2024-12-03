package com.barissemerci.snoozeloo.alarm.alarm_list.presentation

import com.barissemerci.snoozeloo.alarm.alarm_list.presentation.models.AlarmUi
import com.barissemerci.snoozeloo.alarm.core.domain.Alarm

sealed interface AlarmListAction {
    data class OnAlarmClick(val alarm: Alarm) : AlarmListAction
    data object OnAddAlarmClick : AlarmListAction
    data class OnAlarmSwitchChange(val alarm: AlarmUi) : AlarmListAction
}
