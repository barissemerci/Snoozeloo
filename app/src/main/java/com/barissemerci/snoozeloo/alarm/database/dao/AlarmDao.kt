package com.barissemerci.snoozeloo.alarm.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.barissemerci.snoozeloo.alarm.database.entity.AlarmEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AlarmDao {
    @Upsert
    suspend fun upsertAlarm(alarmEntity: AlarmEntity)

    @Query("DELETE FROM alarmEntity WHERE id = :id")
    suspend fun deleteAlarm(id: Long)

    @Query("SELECT * FROM alarmEntity ORDER BY hour, minute")
     fun getAlarms() : Flow<List<AlarmEntity>>

    @Query("SELECT * FROM alarmEntity WHERE id = :id")
     fun getAlarm(id: Long) : Flow<AlarmEntity>
}