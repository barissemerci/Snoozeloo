package com.barissemerci.snoozeloo.alarm.core.domain

import com.barissemerci.snoozeloo.alarm.core.domain.util.DataError
import com.barissemerci.snoozeloo.alarm.core.domain.util.EmptyDataResult
import kotlinx.coroutines.flow.Flow

interface AlarmRepository {
    fun getAlarms(): Flow<List<Alarm>>
    suspend fun getAlarm(id: AlarmId): Flow<Alarm>
    suspend fun upsertAlarm(alarm: Alarm): EmptyDataResult<DataError>
    suspend fun deleteAlarm(id: AlarmId)
}