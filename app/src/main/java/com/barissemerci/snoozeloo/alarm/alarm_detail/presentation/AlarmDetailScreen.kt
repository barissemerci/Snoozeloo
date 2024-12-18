package com.barissemerci.snoozeloo.alarm.alarm_detail.presentation

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.barissemerci.snoozeloo.R
import com.barissemerci.snoozeloo.alarm.alarm_detail.presentation.components.SnoozelooDialog
import com.barissemerci.snoozeloo.alarm.alarm_detail.presentation.components.TimeTextField
import com.barissemerci.snoozeloo.alarm.core.presentation.SnoozelooToolBar
import com.barissemerci.snoozeloo.ui.theme.SnoozelooTheme
import org.koin.androidx.compose.koinViewModel

@Composable

fun AlarmDetailScreenRoot(
    viewModel: AlarmDetailViewModel = koinViewModel(),
    onCancelClick: () -> Unit,
    onNavigateUpAfterSaved: () -> Unit,
    id: Long?
) {
    val context = LocalContext.current

    AlarmDetailScreen(
        state = viewModel.state,
        onAction = { action ->
            when (action) {
                AlarmDetailAction.OnCancelClick -> {
                    onCancelClick()
                }

                is AlarmDetailAction.OnSaveClick -> {
                    Toast.makeText(
                        context,
                        R.string.alarm_saved,
                        Toast.LENGTH_SHORT
                    ).show()
                    onNavigateUpAfterSaved()
                }

                else -> Unit
            }
            viewModel.onAction(action)
        }
    )
}

@Composable

private fun AlarmDetailScreen(
    state: AlarmDetailState,
    onAction: (AlarmDetailAction) -> Unit
) {
    val focusManager = LocalFocusManager.current

    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            SnoozelooToolBar(
                modifier = Modifier.background(MaterialTheme.colorScheme.surface),
                startContent = {
                    IconButton(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16))
                            .background(MaterialTheme.colorScheme.onSurfaceVariant),

                        onClick = {
                            onAction(AlarmDetailAction.OnCancelClick)
                        }
                    ) {
                        Icon(Icons.Filled.Close, contentDescription = "Back")
                    }

                },
                actionItem = {
                    Button(
                        modifier = Modifier.padding(end = 16.dp),
                        onClick = {
                            onAction(
                                AlarmDetailAction.OnSaveClick(
                                    state.alarmHour,
                                    state.alarmMinute,
                                    state.alarmName
                                )
                            )
                        }
                    ) {
                        Text(stringResource(R.string.save))
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.surface)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.background)
                    .padding(16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    TimeTextField(
                        value = state.alarmHour,
                        onValueChange = { onAction(AlarmDetailAction.OnHourChange(it)) })
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(text = ":", fontSize = 32.sp, color = MaterialTheme.colorScheme.onSurface)
                    Spacer(modifier = Modifier.padding(8.dp))
                    TimeTextField(
                        value = state.alarmMinute,
                        onValueChange = { onAction(AlarmDetailAction.OnMinuteChange(it)) }


                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Alarm in 7h 15 min ")
            }


            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .clickable {
                        onAction(AlarmDetailAction.OnNameClick)
                    }
                    .background(MaterialTheme.colorScheme.background)
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.alarm_name),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Text(text = state.alarmName, fontSize = 14.sp)
            }
        }
        if (state.isNameEditing) {
            SnoozelooDialog(
                title = stringResource(R.string.alarm_name),
                onDissmiss = { onAction(AlarmDetailAction.OnNameClick) },
                onSaveClick = {
                    onAction(AlarmDetailAction.OnSaveNameClick(it))
                    focusManager.clearFocus()
                },
                name = state.alarmName,

                )
        }


    }
}

@Preview
@Composable
private fun AlarmDetailScreenPreview() {
    SnoozelooTheme {
        AlarmDetailScreen(
            state = AlarmDetailState(),
            onAction = {}
        )

    }

}