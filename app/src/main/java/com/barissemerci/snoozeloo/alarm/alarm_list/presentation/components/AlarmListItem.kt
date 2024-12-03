package com.barissemerci.snoozeloo.alarm.alarm_list.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.barissemerci.snoozeloo.alarm.alarm_list.presentation.models.AlarmUi
import com.barissemerci.snoozeloo.ui.theme.SnoozelooTheme

@Composable
fun AlarmListItem(
    onSwitchChange: (Boolean) -> Unit = {},
    alarmUi: AlarmUi,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            // contentColor = Color.Red
        )
    ) {
        Column(
            modifier = Modifier
                //  .background(Color.Red)
                .fillMaxWidth()
                .padding(16.dp)


        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = alarmUi.title, fontSize = 16.sp, color = Color.Black)
                Switch(
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        checkedTrackColor = MaterialTheme.colorScheme.primary,
                        uncheckedThumbColor = Color.White,
                        uncheckedTrackColor = Color.Gray
                    ),
                    checked = alarmUi.isEnabled,
                    onCheckedChange = {
                        onSwitchChange(it)
                    },
                )
            }
            Row(
                verticalAlignment = Alignment.Bottom,
            ) {
                Text(
                    text = "${alarmUi.hour}:${alarmUi.minute}",
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.alignBy(LastBaseline)
                )
                Text(
                    text = alarmUi.amPm,
                    fontSize = 24.sp,
                    modifier = Modifier.alignBy(LastBaseline)
                )
            }
            Text(text = alarmUi.alarmInText, fontSize = 14.sp, color = Color.Gray)
        }

    }

}

@Preview
@Composable
private fun AlarmListItemPreview() {

    SnoozelooTheme {
        AlarmListItem(
            alarmUi = AlarmUi(
                title = "Wake Up",
                hour = 10,
                minute = 25,
                amPm = "AM",
                alarmInText = "Alarm in 50 min",
                isEnabled = false,
                id = 1
            )
        )

    }
}