package com.barissemerci.snoozeloo.alarm.triggered_alarm.presentation

sealed interface TriggeredAlarmAction {
    data class OnTurnOffClick(val id : Long) : TriggeredAlarmAction

}