package com.barissemerci.snoozeloo.alarm.alarm_list.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.barissemerci.snoozeloo.R
import com.barissemerci.snoozeloo.ui.AlarmIcon
import com.barissemerci.snoozeloo.ui.theme.SnoozelooTheme

@Composable
fun EmptyListInfo(modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            imageVector = AlarmIcon,
            modifier = Modifier.size(64.dp),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = stringResource(R.string.empty_list_info), textAlign = TextAlign.Center)


    }


}

@Preview
@Composable
private fun EmptyListInfoPreview() {
    SnoozelooTheme {
        EmptyListInfo()
    }
}