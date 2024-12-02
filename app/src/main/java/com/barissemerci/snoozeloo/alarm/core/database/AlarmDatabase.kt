package com.barissemerci.snoozeloo.alarm.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.barissemerci.snoozeloo.alarm.core.database.dao.AlarmDao
import com.barissemerci.snoozeloo.alarm.core.database.entity.AlarmEntity

@Database(entities = [AlarmEntity::class], version = 1)
abstract class AlarmDatabase: RoomDatabase() {
    abstract val alarmDao: AlarmDao
}