package com.barissemerci.snoozeloo.alarm.alarm_list.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.barissemerci.snoozeloo.alarm.alarm_list.presentation.components.SnoozelooFloatingActionButton
import com.barissemerci.snoozeloo.ui.theme.SnoozelooTheme
import org.koin.androidx.compose.koinViewModel

@Composable

fun AlarmListScreenRoot(

    viewModel: AlarmListViewModel = koinViewModel()

) {

    AlarmListScreen(

        state = viewModel.state,

        onAction = viewModel::onAction

    )

}

@Composable

private fun AlarmListScreen(
    state: AlarmListState,
    onAction: (AlarmListAction) -> Unit
) {

Scaffold(
    floatingActionButtonPosition = FabPosition.Center,
    floatingActionButton = {
        SnoozelooFloatingActionButton(
            icon = Icons.Default.Add,
            iconSize = 40.dp,
            onClick = { onAction(AlarmListAction.OnAddAlarmClick) }
        )
    }
) {  }
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