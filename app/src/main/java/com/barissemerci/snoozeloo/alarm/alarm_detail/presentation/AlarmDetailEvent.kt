package com.barissemerci.snoozeloo.alarm.alarm_detail.presentation


sealed interface AlarmDetailEvent {
    data class Error(val message: String) : AlarmDetailEvent

}