package com.barissemerci.snoozeloo

import android.app.Application
import com.barissemerci.snoozeloo.alarm.di.alarmModule
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
                alarmModule
            )
        }
    }
}