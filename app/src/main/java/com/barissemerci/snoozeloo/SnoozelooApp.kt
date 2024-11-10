package com.barissemerci.snoozeloo

import android.app.Application
import com.barissemerci.snoozeloo.alarm.alarm_list.presentation.di.alarmListModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class SnoozelooApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@SnoozelooApp)
            modules(
                alarmListModule
            )
        }
    }
}