package com.barissemerci.snoozeloo.alarm.triggered_alarm.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.barissemerci.snoozeloo.ui.AlarmIcon
import com.barissemerci.snoozeloo.ui.theme.SnoozelooTheme
import org.koin.androidx.compose.koinViewModel

@Composable

fun TriggeredAlarmScreenRoot(
    modifier: Modifier = Modifier,
    onTurnOffClick: () -> Unit,
    viewModel: TriggeredAlarmViewModel = koinViewModel()

) {

    TriggeredAlarmScreen(

        state = viewModel.state,

        onAction =

        { action ->
            when (action) {
                is TriggeredAlarmAction.OnTurnOffClick -> {
                    viewModel.onAction(action)
                    onTurnOffClick()
                }
            }
        }

    )

}

@Composable

private fun TriggeredAlarmScreen(

    state: TriggeredAlarmState,

    onAction: (TriggeredAlarmAction) -> Unit

) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = AlarmIcon,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "${state.alarmHour}:${state.alarmMinute}",
            fontSize = 82.sp,
            fontWeight = FontWeight.W500,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = state.alarmName, fontSize = 24.sp, fontWeight = FontWeight.W600)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            onAction(TriggeredAlarmAction.OnTurnOffClick(state.alarmId))
        }, modifier = Modifier.width(200.dp)) {
            Text(text = "Turn Off", fontSize = 24.sp, fontWeight = FontWeight.W600)
        }
    }


}

@Preview

@Composable

private fun TriggeredAlarmScreenPreview() {
    SnoozelooTheme {
        TriggeredAlarmScreen(
            state = TriggeredAlarmState(
                alarmHour = 12,
                alarmMinute = 30,
                alarmName = "Alarm Name"
            ),
            onAction = {}
        )
    }
}