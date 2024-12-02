package com.barissemerci.snoozeloo.alarm.di

import com.barissemerci.snoozeloo.alarm.alarm_detail.presentation.AlarmDetailViewModel
import com.barissemerci.snoozeloo.alarm.alarm_list.presentation.AlarmListViewModel
import com.barissemerci.snoozeloo.alarm.core.data.AlarmRepositoryImpl
import com.barissemerci.snoozeloo.alarm.core.domain.AlarmRepository
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val alarmModule = module {
    viewModelOf(
        ::AlarmListViewModel
    )
    viewModelOf(
        ::AlarmDetailViewModel
    )
    singleOf(::AlarmRepositoryImpl).bind<AlarmRepository>()



}