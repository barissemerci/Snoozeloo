package com.barissemerci.snoozeloo.alarm.alarm_list.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.barissemerci.snoozeloo.R
import com.barissemerci.snoozeloo.alarm.alarm_list.presentation.components.AlarmListItem
import com.barissemerci.snoozeloo.alarm.alarm_list.presentation.components.EmptyListInfo
import com.barissemerci.snoozeloo.alarm.alarm_list.presentation.components.SnoozelooFloatingActionButton
import com.barissemerci.snoozeloo.alarm.core.presentation.SnoozelooToolBar
import com.barissemerci.snoozeloo.ui.AddIcon
import com.barissemerci.snoozeloo.ui.theme.SnoozelooTheme
import org.koin.androidx.compose.koinViewModel

@Composable

fun AlarmListScreenRoot(
    viewModel: AlarmListViewModel = koinViewModel(),
    onAlarmClick: (id : Long) -> Unit,
    onAddAlarmClick: () -> Unit
) {
    AlarmListScreen(
        state = viewModel.state,
        onAction = { action ->
            when (action) {
                AlarmListAction.OnAddAlarmClick -> onAddAlarmClick()
                else -> Unit
            }
            viewModel.onAction(action)
        }
    )

}

@Composable

private fun AlarmListScreen(
    state: AlarmListState,
    onAction: (AlarmListAction) -> Unit
) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            SnoozelooFloatingActionButton(
                icon = AddIcon,
                iconSize = 25.dp,
                onClick = { onAction(AlarmListAction.OnAddAlarmClick) }
            )
        },
        topBar = {
            SnoozelooToolBar(
                startContent = {
                    Box {
                        Text(text = stringResource(id = R.string.your_alarms))
                    }
                },
            )
        }
    ) { padding ->



            if (state.alarms.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
                    EmptyListInfo()
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.surface).padding(padding).padding(horizontal = 8.dp),
                ) {
                    items(state.alarms) { alarm ->
                        AlarmListItem(
                            alarmUi = alarm,

                            )
                    }
                }


        }
    }
}
@Preview

@Composable

private fun AlarmListScreenPreview() {

    SnoozelooTheme {

        AlarmListScreen(

            state = AlarmListState(),

            onAction = {}

        )

    }

}