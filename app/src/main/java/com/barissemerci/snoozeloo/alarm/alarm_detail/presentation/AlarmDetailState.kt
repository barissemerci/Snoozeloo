package com.barissemerci.snoozeloo.alarm.alarm_detail.presentation

import androidx.compose.foundation.text.input.TextFieldState

data class AlarmDetailState(
    val alarmHour: TextFieldState = TextFieldState("00"),
    val alarmMinute:TextFieldState = TextFieldState("00"),
    val alarmName: TextFieldState = TextFieldState()
)
