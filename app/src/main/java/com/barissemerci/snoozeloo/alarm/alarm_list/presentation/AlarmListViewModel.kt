package com.barissemerci.snoozeloo.alarm.alarm_list.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AlarmListViewModel : ViewModel() {
    var state by mutableStateOf(AlarmListState())
        private set
    fun onAction(action: AlarmListAction){

    }
}