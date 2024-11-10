package com.barissemerci.snoozeloo.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.barissemerci.snoozeloo.R

val AddIcon: ImageVector
    @Composable
    get() = ImageVector.vectorResource(id = R.drawable.union)

val AlarmIcon: ImageVector
    @Composable
    get() = ImageVector.vectorResource(id = R.drawable.snoozeloo)