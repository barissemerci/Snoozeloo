package com.barissemerci.snoozeloo.alarm.core.domain

data class Alarm(
    val id: Long?,
    val name: String,
    val hour : Int,
    val minute : Int,
    val isEnabled : Boolean = true
)
