@file:OptIn(ExperimentalMaterial3Api::class)

package com.barissemerci.snoozeloo.alarm.core.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.barissemerci.snoozeloo.ui.theme.SnoozelooTheme

@Composable
fun SnoozelooToolBar(
    modifier: Modifier = Modifier,
    onActionItemClick: () -> Unit = {},
    actionItem: (@Composable () -> Unit)? = null,
    onStartItemClick: () -> Unit = {},
    startContent: (@Composable () -> Unit)? = null,
) {
    TopAppBar(
        title = {
            Box(  modifier = Modifier.clickable { onStartItemClick() }){
                startContent?.invoke()
            }

        },
        modifier = modifier,
        actions = {
            Box(
                modifier = Modifier.clickable { onActionItemClick() }
            ) {
                actionItem?.invoke()
            }

        }
    )
}
    @Preview
    @Composable
    private fun SnoozelooToolBarPreview() {
        SnoozelooTheme {
            SnoozelooToolBar(
                onActionItemClick = {},
                actionItem = {
                    Box {

                    }
                },
                startContent = {
                    Box {
                        Text(text = "Your Alarms")
                        }
                }
            )
        }

    }
