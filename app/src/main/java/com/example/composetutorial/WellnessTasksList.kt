package com.example.composetutorial

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    onCheckedTask: (WellnessTask) -> Unit,
    onCloseTask: (WellnessTask) -> Unit,
    list: List<WellnessTask> = remember { getWellnessTasks() }
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(list) {
            WellnessTaskItem(
                taskName = it.label,
                checked = it.checked,
                onCheckedChange = { task ->
                    onCheckedTask(it)
                },
                onClose = {
                    onCloseTask(it)
                }
            )
        }
    }
}