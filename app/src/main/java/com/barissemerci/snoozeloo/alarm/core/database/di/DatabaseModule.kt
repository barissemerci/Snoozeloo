package com.barissemerci.snoozeloo.alarm.core.database.di

import androidx.room.Room
import com.barissemerci.snoozeloo.alarm.core.domain.LocalAlarmDataSource
import com.barissemerci.snoozeloo.alarm.core.database.AlarmDatabase
import com.barissemerci.snoozeloo.alarm.core.database.RoomLocalAlarmDataSource
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AlarmDatabase::class.java,
            "alarm.db"
        ).build()
    }
    single {
        get<AlarmDatabase>().alarmDao
    }

    singleOf(::RoomLocalAlarmDataSource).bind<LocalAlarmDataSource>()

}