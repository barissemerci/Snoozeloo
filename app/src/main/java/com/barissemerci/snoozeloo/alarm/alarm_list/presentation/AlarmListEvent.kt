package com.barissemerci.snoozeloo.alarm.alarm_list.presentation

sealed interface AlarmListEvent {
    data class Error(val message: String) : AlarmListEvent
}