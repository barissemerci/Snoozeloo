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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.barissemerci.snoozeloo.ui.theme.SnoozelooTheme

@Composable
fun SnoozelooDialog(
    title: String,
    onDissmiss: () -> Unit,
    primaryButton: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    secondaryButton: @Composable () -> Unit = {}

) {
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
                value = "",
                onValueChange = {},
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unfocusedBorderColor = MaterialTheme.colorScheme.onSurfaceVariant,

                ),
                modifier = Modifier.fillMaxWidth().height(36.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                secondaryButton()
                primaryButton()
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
            primaryButton = {
               Button(onClick = { /*TODO*/ }) {
                    Text(text = "Save")
                }
            },
            secondaryButton = {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Cancel")
                }
            }

        )
    }
    
}