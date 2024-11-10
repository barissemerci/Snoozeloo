package com.barissemerci.snoozeloo.alarm.alarm_list.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.barissemerci.snoozeloo.R
import com.barissemerci.snoozeloo.alarm.alarm_list.presentation.components.EmptyListInfo
import com.barissemerci.snoozeloo.alarm.alarm_list.presentation.components.SnoozelooFloatingActionButton
import com.barissemerci.snoozeloo.ui.AddIcon
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
                icon = AddIcon,
                iconSize = 25.dp,
                onClick = { onAction(AlarmListAction.OnAddAlarmClick) }
            )
        }
    ) { padding ->
        Column(modifier = Modifier
            .padding(padding)
            .padding(16.dp)) {
            Text(text = stringResource(id = R.string.your_alarms), fontSize = 24.sp)


            if (state.alarms.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    EmptyListInfo()
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    item {

                    }
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