package com.barissemerci.snoozeloo.alarm.core.domain

import com.barissemerci.snoozeloo.alarm.core.domain.util.DataError
import com.barissemerci.snoozeloo.alarm.core.domain.util.Result
import kotlinx.coroutines.flow.Flow

typealias AlarmId = Long

interface LocalAlarmDataSource {
    fun getAlarms(): Flow<List<Alarm>>

    fun getAlarm(id: AlarmId): Flow<Alarm>

    suspend fun upsertAlarm(alarm: Alarm): Result<AlarmId, DataError.Local>

    suspend fun deleteAlarm(id:AlarmId )

}