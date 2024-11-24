package com.barissemerci.snoozeloo.alarm.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class AlarmEntity(
    val hour : Int,
    val minute : Int,
    val name : String,
    @PrimaryKey(autoGenerate = true)
    val id : Long
)