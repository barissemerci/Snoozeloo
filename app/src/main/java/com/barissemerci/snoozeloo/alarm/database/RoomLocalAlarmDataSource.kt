package com.barissemerci.snoozeloo.alarm.database

import android.database.sqlite.SQLiteFullException
import com.barissemerci.snoozeloo.alarm.core.domain.Alarm
import com.barissemerci.snoozeloo.alarm.core.domain.AlarmId
import com.barissemerci.snoozeloo.alarm.core.domain.LocalAlarmDataSource
import com.barissemerci.snoozeloo.alarm.core.domain.util.DataError
import com.barissemerci.snoozeloo.alarm.core.domain.util.Result
import com.barissemerci.snoozeloo.alarm.database.dao.AlarmDao
import com.barissemerci.snoozeloo.alarm.database.mapper.toAlarm
import com.barissemerci.snoozeloo.alarm.database.mapper.toAlarmEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoomLocalAlarmDataSource(private val alarmDao: AlarmDao) : LocalAlarmDataSource {
    override fun getAlarms(): Flow<List<Alarm>> {
        return alarmDao.getAlarms().map { alarms ->
            alarms.map { it.toAlarm() }
        }
    }


    override fun getAlarm(id: AlarmId): Flow<Alarm> {
        return alarmDao.getAlarm(id).map { it.toAlarm() }
    }

    override suspend fun upsertAlarm(alarm: Alarm): Result<AlarmId, DataError.Local> {
        return try {
            val entity = alarm.toAlarmEntity()
            alarmDao.upsertAlarm(entity)
            Result.Success(entity.id)
        } catch (e: SQLiteFullException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun deleteAlarm(id: AlarmId) {
        alarmDao.deleteAlarm(id)
    }
}