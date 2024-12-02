package com.barissemerci.snoozeloo.alarm.alarm_list.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barissemerci.snoozeloo.alarm.alarm_list.presentation.mappers.toAlarmUi
import com.barissemerci.snoozeloo.alarm.core.domain.AlarmRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class AlarmListViewModel(
    private val alarmRepository: AlarmRepository
) : ViewModel() {
    var state by mutableStateOf(AlarmListState())
        private set
    init {
        alarmRepository.getAlarms().onEach { alarms ->
            val alarmsUi = alarms.map { it.toAlarmUi() }
            state = state.copy(alarms = alarmsUi)
        }.launchIn(viewModelScope)
    }

    fun onAction(action: AlarmListAction){

    }
}