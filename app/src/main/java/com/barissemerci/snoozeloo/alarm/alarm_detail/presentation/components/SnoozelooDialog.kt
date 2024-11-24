package com.barissemerci.snoozeloo.alarm.alarm_detail.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.barissemerci.snoozeloo.R
import com.barissemerci.snoozeloo.ui.theme.SnoozelooDarkGray
import com.barissemerci.snoozeloo.ui.theme.SnoozelooTheme

@Composable
fun SnoozelooDialog(
    title: String,
    name: String?,
    onDissmiss: () -> Unit,
    modifier: Modifier = Modifier,
    onSaveClick: (String) -> Unit,

    ) {
    var text by remember { mutableStateOf(name) }
    Dialog(onDismissRequest = onDissmiss) {

        Column(
            modifier = modifier
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colorScheme.surface)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),

            ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
            OutlinedTextField(
                value = text ?: "",
                singleLine = true,
                onValueChange = {
                    text = it
                },
                placeholder = {
                    Text(text = stringResource(R.string.enter_an_alarm_name), color = SnoozelooDarkGray)
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unfocusedBorderColor = MaterialTheme.colorScheme.onSurfaceVariant,

                    ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(0.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Button(onClick = { onSaveClick(text.toString()) }
                ) {
                    Text(text = stringResource(R.string.save))
                }
            }
        }
    }

}

@Preview
@Composable
private fun SnoozelooDialogPreview() {
    SnoozelooTheme {
        SnoozelooDialog(
            title = "Alarm Name",
            onDissmiss = {},
            onSaveClick = {},
            name = "Work",


            )
    }

}