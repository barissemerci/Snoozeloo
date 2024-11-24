package com.barissemerci.snoozeloo.alarm.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.barissemerci.snoozeloo.alarm.database.dao.AlarmDao
import com.barissemerci.snoozeloo.alarm.database.entity.AlarmEntity

@Database(entities = [AlarmEntity::class], version = 1)
abstract class AlarmDatabase: RoomDatabase() {
    abstract val alarmDao: AlarmDao
}