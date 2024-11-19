package com.barissemerci.snoozeloo.alarm.alarm_detail.presentation

sealed interface AlarmDetailAction {
    data class OnSaveClick(val alarmHour: String, val alarmMinute: String, val alarmName: String) :
        AlarmDetailAction

    data object OnCancelClick : AlarmDetailAction
    data object OnChangeNameClick : AlarmDetailAction
    data class OnSaveAlarmNameClick(val alarmName: String) : AlarmDetailAction
}