package com.barissemerci.snoozeloo.alarm.di

import com.barissemerci.snoozeloo.alarm.alarm_detail.presentation.AlarmDetailViewModel
import com.barissemerci.snoozeloo.alarm.alarm_list.presentation.AlarmListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val alarmModule = module {
    viewModelOf(
       ::AlarmListViewModel
    )
    viewModelOf(
       ::AlarmDetailViewModel
    )
}