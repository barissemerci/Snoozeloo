package com.barissemerci.snoozeloo.alarm.core.data

import com.barissemerci.snoozeloo.alarm.core.domain.Alarm
import com.barissemerci.snoozeloo.alarm.core.domain.AlarmId
import com.barissemerci.snoozeloo.alarm.core.domain.AlarmRepository
import com.barissemerci.snoozeloo.alarm.core.domain.LocalAlarmDataSource
import com.barissemerci.snoozeloo.alarm.core.domain.util.DataError
import com.barissemerci.snoozeloo.alarm.core.domain.util.EmptyDataResult
import com.barissemerci.snoozeloo.alarm.core.domain.util.asEmptyDataResult
import kotlinx.coroutines.flow.Flow

class AlarmRepositoryImpl(
    private val localAlarmDataSource: LocalAlarmDataSource
) : AlarmRepository {
    override fun getAlarms(): Flow<List<Alarm>> {
        return localAlarmDataSource.getAlarms()
    }

    override suspend fun getAlarm(id: AlarmId): Flow<Alarm> {
        return localAlarmDataSource.getAlarm(id)
    }

    override suspend fun upsertAlarm(alarm: Alarm): EmptyDataResult<DataError> {
        val localResult = localAlarmDataSource.upsertAlarm(alarm)
        return localResult.asEmptyDataResult()
    }


    override suspend fun deleteAlarm(id: AlarmId) {
        localAlarmDataSource.deleteAlarm(id)
    }
}