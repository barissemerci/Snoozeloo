package com.barissemerci.snoozeloo.alarm.alarm_detail.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.barissemerci.snoozeloo.ui.theme.SnoozelooTheme

@Composable
fun TimeTextField(
    state: TextFieldState,
    keyboardType: KeyboardType = KeyboardType.Number,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(width = 125.dp, height = 90.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.surface)


    ) {
        BasicTextField(
            state = state,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
            ),
            textStyle = LocalTextStyle.current.copy(
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 64.sp,
                lineHeight = 64.sp,
                textAlign = TextAlign.Center
            ),
            lineLimits = TextFieldLineLimits.SingleLine,


            )


    }

}

@Preview
@Composable
private fun TimeTextFieldPreview() {
    SnoozelooTheme {
        TimeTextField(
            state = TextFieldState()
        )
    }
}