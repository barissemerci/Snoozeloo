package com.barissemerci.snoozeloo.alarm.alarm_list.presentation.di

import com.barissemerci.snoozeloo.alarm.alarm_list.presentation.AlarmListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val alarmListModule = module {
    viewModelOf(
        ::AlarmListViewModel
    )
}