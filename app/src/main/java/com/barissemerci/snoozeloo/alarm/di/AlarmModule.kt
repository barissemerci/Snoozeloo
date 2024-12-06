package com.barissemerci.snoozeloo.alarm.di

import com.barissemerci.snoozeloo.alarm.alarm_detail.presentation.AlarmDetailViewModel
import com.barissemerci.snoozeloo.alarm.alarm_list.presentation.AlarmListViewModel
import com.barissemerci.snoozeloo.alarm.core.data.AlarmRepositoryImpl
import com.barissemerci.snoozeloo.alarm.core.domain.AlarmRepository
import com.barissemerci.snoozeloo.alarm.triggered_alarm.presentation.TriggeredAlarmViewModel
import com.barissemerci.snoozeloo.alarm.util.AlarmScheduler
import org.koin.android.ext.koin.androidApplication
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
    viewModelOf(
        ::TriggeredAlarmViewModel
    )
    singleOf(::AlarmRepositoryImpl).bind<AlarmRepository>()

    single { AlarmScheduler(androidApplication()) }

}